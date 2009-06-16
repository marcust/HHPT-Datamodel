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

}
