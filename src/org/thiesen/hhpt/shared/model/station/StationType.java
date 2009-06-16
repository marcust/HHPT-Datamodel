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

import org.thiesen.hhpt.shared.model.tag.HighwayTag;
import org.thiesen.hhpt.shared.model.tag.RailwayTag;
import org.thiesen.hhpt.shared.model.tag.Tag;


public enum StationType {

    BUS_STOP( HighwayTag.withValue( "bus_stop" ) ),
    BUS_STATION( HighwayTag.withValue( "bus_station" ) ),
    TRAM_STOP( RailwayTag.withValue( "station" ) ),
    RAILWAY_STATION( RailwayTag.withValue( "station" ) ),
    RAILWAY_ENTRANCE( RailwayTag.withValue( "subway_entrance" ) ),
    RAILWAY_HALT( RailwayTag.withValue( "halt" ) );
    
    private final Tag _identificationTag;
    
    private StationType( final Tag identificationTag ) {
        _identificationTag = identificationTag;
    }

    public static StationType valueOf( final String key, final String value ) {
        for ( final StationType t : values() ) {
            if ( t.isEqualTo( key, value ) ) {
                return t;
            }
        }
        return null;
    }

    private boolean isEqualTo( final String key, final String value ) {
        return _identificationTag.equals( key, value );
        
    }

    public void appendWithSep( final StringBuilder retval, final char sep ) {
        retval.append( this ).append( sep );
    }

    public boolean isBus() {
        if ( BUS_STATION == this ) return true;
        if ( BUS_STOP == this ) return true;
        
        return false;
        
    }

    public boolean istTrain() {
        return !isBus();
        
    }

    
}
