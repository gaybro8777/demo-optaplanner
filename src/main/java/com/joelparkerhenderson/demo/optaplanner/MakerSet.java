package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MakerSet extends Trackable<MakerSet> implements ToStringDeep, ToXMLString, FromXMLString, HasName, HasTagSet {

    //@Interface FromXMLString
    public static MakerSet fromXMLString(String xml) {
        return (MakerSet)AppXML.fromXML(xml);
    }

    private Set<Maker> makers;

    public Set<Maker> getMakers() {
        return makers;
    }

    public void setMakers(Set<Maker> makers) {
        this.makers = makers;
    }

}
