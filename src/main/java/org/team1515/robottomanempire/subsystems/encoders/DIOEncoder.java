package org.team1515.robottomanempire.subsystems.encoders;

import org.team1515.robottomanempire.util.Pair;

import edu.wpi.first.wpilibj.Encoder;

public class DIOEncoder implements GenericEncoder {

    private Encoder encoder;

    public DIOEncoder(Pair<Integer> ids) {
        encoder = new Encoder(ids.first, ids.last);
    }

    @Override
    public double get() {
        return encoder.getRate() / 100.0;
    }

    @Override
    public void reset() {
        encoder.reset();
    }


}