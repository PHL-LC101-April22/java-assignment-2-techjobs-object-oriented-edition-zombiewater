package org.launchcode.techjobs.oo;

import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }



    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        String nullCondition = "Data not available";
        String sName = name;
        String sEmployer = employer.toString();
        String sLocation = location.toString();
        String sPositionType = positionType.toString();
        String sCoreCompetency = coreCompetency.toString();

        ArrayList<String> iterList = new ArrayList<>();
        ArrayList<String> actualList = new ArrayList<>();
        iterList.add(sName);
        iterList.add(sEmployer);
        iterList.add(sLocation);
        iterList.add(sPositionType);
        iterList.add(sCoreCompetency);

        int num = 0;

        for (String entry:iterList){
            if (entry == null || entry.isEmpty()){
                actualList.add(nullCondition);
                num++;
                if (num == iterList.size()) {
                    return "OOPS! This job does not seem to exist.";
                }
            } else {
                actualList.add(entry);
            }
        }

        return "\nID:  " + getId() + "\nName:  " + actualList.get(0) + "\nEmployer:  " + actualList.get(1) + "\nLocation:  " + actualList.get(2)+ "\nPosition Type:  " + actualList.get(3)  +
                "\nCore Competency:  " + actualList.get(4) + "\n";
    }
    public String getName() {
       return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
// TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


}
