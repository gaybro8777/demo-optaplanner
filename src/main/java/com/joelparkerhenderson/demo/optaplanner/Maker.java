package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Maker implements ToStringDeep, ToXMLString, FromXMLString, HasName, HasTagSet, Comparable<Maker>{

    public String toString(){
        return "name:" + ((name != null) ? name : "null");
    }

    @Override
    public String toStringDeep(){
        return toString();
    }

    @Override
    public String toXMLString()
    {
        return AppXML.toXML(this);
    }

    //@Interface FromXMLString
    public static Maker fromXMLString(String xml)
    {
        return (Maker)AppXML.fromXML(xml);
    }

    private String name;

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    private TagSet tagSet;

    @Override
    public TagSet getTagSet(){
        return tagSet;
    }

    @Override
    public void setTagSet(TagSet tagSet){
        this.tagSet = tagSet;
    }

    @Override
    public int compareTo(Maker that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

}
