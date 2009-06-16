package org.thiesen.hhpt.shared.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;

import org.thiesen.hhpt.shared.model.station.Station;


public class StationReader implements Iterable<Station> {

    private final ByteBuffer _fileContentsBuffer;
    final byte[] _charBuffer = new byte[ 1024 * 1024 ]; 
    private Station _nextStation;

    public StationReader( final String filename ) throws FileNotFoundException, IOException {
        this( new File( filename ) );
    }


    public StationReader( final File file ) throws FileNotFoundException, IOException {
        _fileContentsBuffer = mapFile( file );
    }


    public StationReader( final FileChannel channel ) throws FileNotFoundException, IOException {
        _fileContentsBuffer = mapFile( channel );
    }


    public StationReader( final InputStream stream ) throws IOException {
        final ByteArrayOutputStream os = new ByteArrayOutputStream();

        final byte[] b = new byte[1024];  
        int read;  
        while ((read = stream.read(b)) != -1) {  
            os.write(b, 0, read);  
        }  
    
        _fileContentsBuffer = ByteBuffer.wrap( os.toByteArray() );
    }  
    



private ByteBuffer mapFile( final File file ) throws IOException {
    final FileChannel readChannel = new RandomAccessFile( file, "r" ).getChannel();
    return mapFile( readChannel );
}


private String readOneField( ) {
    byte readByte = 0;
    int length = 0;

    while ( _fileContentsBuffer.hasRemaining()  && ( readByte = _fileContentsBuffer.get() ) != '\0' ) {
        _charBuffer[length++] = readByte;
    }

    try {
        return length > 0 ? new String( _charBuffer, 0, length, "utf8" ) : "";
    } catch ( final UnsupportedEncodingException e ) {
        throw new RuntimeException( e );
    }
}


private ByteBuffer mapFile( final FileChannel readChannel ) throws FileNotFoundException, IOException {


    final long fileSize = readChannel.size();

    final ByteBuffer mapFile = readChannel.map( FileChannel.MapMode.READ_ONLY, 0, fileSize);
    readChannel.close();

    return mapFile;
}

private Station readOneStation() {
    final String startOfEntry = readOneField();

    if ( startOfEntry.length() == 0 ) {
        return null;
    }

    final Station retval = Station.createStation( startOfEntry,
            readOneField(),
            readOneField(),
            readOneField(),
            readOneField(),
            readOneField());

    skipNextline();

    return retval;
}




private void skipNextline() {
    if ( _fileContentsBuffer.hasRemaining() ) {
        _fileContentsBuffer.get();
    }

}


public Iterator<Station> iterator() {
    readNextStation();

    return new Iterator<Station>() {



        public void remove() {
            throw new UnsupportedOperationException( );

        }

        public Station next() {
            return readNextBookAndReturnLast();
        }



        public boolean hasNext() {
            return _nextStation != null;
        }
    };

}


private void readNextStation() {
    _nextStation = readOneStation();

}

private Station readNextBookAndReturnLast() {
    final Station returnValue = _nextStation;

    readNextStation();

    return returnValue;
}


}
