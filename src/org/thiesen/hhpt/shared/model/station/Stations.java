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
package org.thiesen.hhpt.shared.model.station;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Stations implements Iterable<Station> {

    private final List<Station> _stations;
    
    public Stations() {
        _stations = new LinkedList<Station>();
    }
    

    public void add( final String id, final String latitude, final String longitude, final StationType type, final String name, final String operator ) {
        _stations.add( Station.createStation( id, latitude, longitude, type, name, operator )  );
    }

    
    public String asFileString() {
        final StringBuilder retval = new StringBuilder();
        for ( final Station s : _stations ) {
            s.appendLineTo( retval );
        }
        
        return retval.toString();
    }

    public void add( final Station s ) {
        _stations.add( s );
        
    }
    
    public UnmodifiableStations freeze() {
        final UnmodifiableStations s = new UnmodifiableStations( _stations ) ;
        return s;
    }


    public Iterator<Station> iterator() {
        return _stations.iterator();
    }


    public int size() {
        return _stations.size();
    }
   
}
