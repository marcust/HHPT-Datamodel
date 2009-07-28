/*
 * $ Id $
 * (c) Copyright 2009 freiheit.com technologies gmbh
 *
 * This file contains unpublished, proprietary trade secret information of
 * freiheit.com technologies gmbh. Use, transcription, duplication and
 * modification are strictly prohibited without prior written consent of
 * freiheit.com technologies gmbh.
 *
 * Initial version by Marcus Thiesen (marcus.thiesen@freiheit.com)
 */
package org.thiesen.hhpt.shared.io;

import java.io.IOException;
import java.io.InputStream;

public class StreamWrapper implements ReadableByteInput {
    
    private final InputStream _stream;
    
    public StreamWrapper( final InputStream stream ) {
        _stream = stream;
    }

    public byte get() {
        try {
            return (byte)_stream.read();
        } catch ( final IOException e ) {
            return 0x0;
        }
    }

    public boolean hasRemaining() {
        try {
            return _stream.available() > 0;
        } catch ( final IOException e ) {
            return false;
        }
    }

}
