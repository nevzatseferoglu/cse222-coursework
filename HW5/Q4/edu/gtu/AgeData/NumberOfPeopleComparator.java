package edu.gtu.AgeData;


import java.util.Comparator;

/**
 * Comparator for AgeData Class.
 */
public class NumberOfPeopleComparator implements Comparator<AgeData> {

    /**
     * Compare the AgeData instance according to their numberOfPeople field.
     * @param ageData AgeData instance.
     * @param t1 AgeData instance
     * @return 1 if the first instance bigger than second , return 0  if they are equal , return -1 if the first one instance smaller than second.
     */
    @Override
    public int compare(AgeData ageData, AgeData t1) {
        return Integer.compare(ageData.getNumberOfPeople(), t1.getNumberOfPeople());
    }
}