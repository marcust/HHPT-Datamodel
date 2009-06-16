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

public class Longitude extends GeoCoordValue {

    private static final long serialVersionUID = 612319579323053767L;

    private Longitude( final Double value ) {
        super( value );
    }

    public static Longitude valueOf( final String longitude ) {
        return new Longitude( Double.valueOf( longitude ) );
        
    }

    public static Longitude valueOfE6( final int minLon ) {
        return new Longitude( Double.valueOf( minLon / 1.0E6 ) );
        
    }

    public boolean isBetween( final Longitude minLon, final Longitude maxLon ) {
        return valueBetween( minLon, maxLon );
    }

  
}
