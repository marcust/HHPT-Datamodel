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
package org.thiesen.hhpt.shared.model.position;

import java.io.Serializable;


public class Position implements Serializable {

    private final Latitude _lat;
    private final Longitude _lon;
    
    private Position( final Latitude latitude, final Longitude longitude ) {
        _lon = longitude;
        _lat = latitude;
    }
    
    public static Position valueOf( final String latitude, final String longitude ) {
        return new Position( Latitude.valueOf( latitude ), Longitude.valueOf( longitude ) );
    }

    public void appendWithSep( final StringBuilder retval, final char sep ) {
        _lat.appendWithSep( retval, sep );
        _lon.appendWithSep( retval, sep );
    }

    public int getLatitudeE6() {
        return _lat.asValueE6();
        
    }

    public int getLongitudeE6() {
        return _lon.asValueE6();
        
    }

    public boolean isWithin( final Latitude minLat, final Latitude maxLat, final Longitude minLon, final Longitude maxLon ) {
        return _lat.isBetween( minLat, maxLat ) && _lon.isBetween( minLon, maxLon );
        
    }

    public Double getLatitude() {
        return _lat.getValue();
    }

    public Double getLongitude() {
        return _lon.getValue();
    }
    
}
