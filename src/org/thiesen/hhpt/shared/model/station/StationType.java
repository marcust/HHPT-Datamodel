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
