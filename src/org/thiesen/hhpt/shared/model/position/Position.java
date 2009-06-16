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

package org.thiesen.hhpt.shared.model.position;

import java.io.Serializable;


public class Position implements Serializable {

    private static final long serialVersionUID = -4168594018071593618L;
    
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
