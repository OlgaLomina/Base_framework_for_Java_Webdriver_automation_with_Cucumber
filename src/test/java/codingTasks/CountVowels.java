package straightWithoutBdd.ui.tests.codingchallenges;

import io.cucumber.java.nl.Stel;
import org.testng.annotations.Test;
import utils.Loggable;

import javax.sql.rowset.spi.SyncFactoryException;
import java.util.*;


public class CountVowels implements Loggable {

    @Test
    public void test(){
        int ct = getCount("noodles");
        getLogger().info("No. of vowels: "+ct);
    }

    private int getCount(String str) {
        int vowelsCount = 0;
        // your code here

        Set<Character> vSet = new HashSet<>();
        vSet.add('a');
        vSet.add('e');
        vSet.add('i');
        vSet.add('o');
        vSet.add('u');


        for (int i=0;i<str.length();i++){
            if (vSet.contains(str.charAt(i))){
                vowelsCount++;
            }

        }
        return vowelsCount;
    }

}