/*
 * $ Id $
 * (c) Copyright 2009 Marcus Thiesen (marcus@thiesen.org)
 *
 *  This file is part of HHPT.
 *
 *  HHPT is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  HHPT is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with HHPT.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.thiesen.hhpt.shared.model.station;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Stations implements Iterable<Station>, Serializable {

    private static final long serialVersionUID = -3475592481658583419L;
    private final List<Station> _stations;
    
    public Stations( final Collection<Station> stations ) {
        _stations = new LinkedList<Station>( stations );
    }
    
    public Stations() {
        _stations = new LinkedList<Station>();
    }
    

    public void add( final String id, final String latitude, final String longitude, final String geohash, final StationType type, final String name, final String operator ) {
        _stations.add( Station.createStation( id, latitude, longitude, geohash, type, name, operator )  );
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

    public boolean isNotEmpty() {
        return !_stations.isEmpty();
        
    }

    public static Stations union( final Stations... stations ) {
        final Stations retval = new Stations();
        
        for ( final Stations s : stations ) {
            retval._stations.addAll( s._stations );
        }
        
        return retval;
    }
   
}
