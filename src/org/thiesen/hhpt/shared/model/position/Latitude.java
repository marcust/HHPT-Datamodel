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


public class Latitude extends GeoCoordValue {

    private static final long serialVersionUID = -4027737685805421591L;

    private Latitude( final Double value ) {
        super( value );
    }
    
    public static Latitude valueOf( final String latitude ) {
        return new Latitude( Double.valueOf( latitude ) );
    }


    public static Latitude valueOfE6( final int latitude ) {
        return new Latitude( Double.valueOf( latitude / 1.0E6  ) );
    }

    public boolean isBetween( final Latitude minLat, final Latitude maxLat ) {
        return valueBetween( minLat, maxLat );
        
    }

    public static Latitude valueOf( final double lat ) {
        return new Latitude( Double.valueOf( lat ) );
    }
    
    
    
    

}
