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


public class StationName implements Serializable {

    private static final long serialVersionUID = 4509557855817257433L;
    
    private final String _name;
    
    private StationName( final String name ) {
        _name = name;
    }
    
    public static StationName valueOf( final String name ) {
        return new StationName( name == null ? "" : name );
    }

    public void appendWithSep( final StringBuilder retval, final char sep ) {
        retval.append( _name ).append( sep );
    }

    public String asString() {
        return _name;
        
    }
    
}
