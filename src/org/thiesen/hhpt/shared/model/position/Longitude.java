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
