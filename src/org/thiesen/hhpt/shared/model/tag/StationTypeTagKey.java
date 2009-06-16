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

package org.thiesen.hhpt.shared.model.tag;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum StationTypeTagKey {
    HIGHWAY, RAILWAY;

    private final static String[] LOWER_CASE_NAMES;
    
    static {
        
        final List<String> values = new LinkedList<String>();
        
        for ( final StationTypeTagKey key : values() ) {
            values.add( key.toString().toLowerCase() );
        }
        
        LOWER_CASE_NAMES = values.toArray( new String[0] );
    }
    
    public static Iterable<String> toXMLKeys() {
        return Arrays.asList( LOWER_CASE_NAMES );
    }
}
