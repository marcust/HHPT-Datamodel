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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UnmodifiableStations implements Iterable<Station> {

    private final List<Station> _stations;
    
    public UnmodifiableStations( final List<Station> stations ) {
        _stations = Collections.unmodifiableList( new ArrayList<Station>( stations ) );
    }

    public Station get( final int i ) {
        return _stations.get( i );
    }

    public int getCount() {
        return _stations.size();
    }

    public Iterator<Station> iterator() {
        return new ArrayList<Station>( _stations ).iterator();
        
    }

}
