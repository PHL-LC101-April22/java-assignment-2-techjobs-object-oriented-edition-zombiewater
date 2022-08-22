package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(),job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
       Job TestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(TestJob instanceof Job);
        assertTrue(TestJob.getEmployer() instanceof Employer);
        assertTrue(TestJob.getLocation() instanceof Location);
        assertTrue(TestJob.getPositionType() instanceof PositionType);
        assertTrue(TestJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(TestJob.getName(),"Product tester");
        assertEquals(TestJob.getEmployer().toString(),"ACME");
        assertEquals(TestJob.getLocation().toString(),"Desert");
        assertEquals(TestJob.getPositionType().toString(), "Quality control");
        assertEquals(TestJob.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job TestJob = new Job("",new Employer("BestBuy"), new Location(), new PositionType(), new CoreCompetency());
        String TestString = "\nID: 4\nName: Data not available\nEmployer: BestBuy\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n";
        assertEquals(TestJob.toString(),TestString);

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job TestJob = new Job("On Call Staff",new Employer(), new Location(), new PositionType(), new CoreCompetency());
        assertTrue(TestJob.toString().startsWith("\n"));
        assertTrue(TestJob.toString().endsWith("\n"));
        assertEquals(TestJob.toString().charAt(0),'\n');
        assertEquals(TestJob.toString().charAt(TestJob.toString().length()-1),'\n');
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job TestJob = new Job("",new Employer(), new Location(), new PositionType(), new CoreCompetency());
        String TestString = "OOPS! This job does not seem to exist.";
        assertEquals(TestJob.toString(),TestString);
    }

}
