package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class SolutionTest
{
    @Test
    public void toStringWithDefault()
    {
        final Solution o = new Solution();
        assertEquals("name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Solution o = new Solution();
        final String name = "foo";
        o.setName(name);
        assertEquals("name:foo", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Solution o = new Solution();
        assertEquals("name:null,matchers:[]", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Solution o = new Solution();
        o.setName("A");
        final Matcher matcher = new Matcher();
        matcher.setName("B");
        final Maker maker = new Maker(); maker.setName("C"); matcher.setMaker(maker);
        final Taker taker = new Taker(); taker.setName("D"); matcher.setTaker(taker);
        final Set<Matcher> matchers = new HashSet<Matcher>();
        matchers.add(matcher);     
        o.setMatchers(matchers);
        assertEquals("name:A,matchers:[matcher:{name:B,maker:{name:C},taker:{name:D}}]", o.toStringDeep());
    }

    @Test
    public void name()
    {
        final Solution o = new Solution();
        final String name = "foo";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void score()
    {
        final Solution o = new Solution();
        final HardSoftScore score = HardSoftScore.of(123,456);
        o.setScore(score);
        assertSame(score, o.getScore());
    }

    @Test
    public void makers()
    {
        final Solution o = new Solution();
        final Set<Maker> makers = new HashSet<Maker>();
        o.setMakers(makers);
        assertSame(makers, o.getMakers());
    }

    @Test
    public void takers()
    {
        final Solution o = new Solution();
        final Set<Taker> takers = new HashSet<Taker>();
        o.setTakers(takers);
        assertSame(takers, o.getTakers());
    }

    @Test
    public void matchers()
    {
        final Solution o = new Solution();
        final Set<Matcher> matchers = new HashSet<Matcher>();
        o.setMatchers(matchers);
        assertSame(matchers, o.getMatchers());
    }

}