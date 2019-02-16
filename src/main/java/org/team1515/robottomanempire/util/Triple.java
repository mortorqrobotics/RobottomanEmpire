package org.team1515.robottomanempire.util;

public class Triple<Type> {
	
    public Type first;
    public Type second;
	public Type last;
	
	public Triple(Type first, Type second, Type last) {
		this.first = first;
        this.second = second;
        this.last = last;
	}

}