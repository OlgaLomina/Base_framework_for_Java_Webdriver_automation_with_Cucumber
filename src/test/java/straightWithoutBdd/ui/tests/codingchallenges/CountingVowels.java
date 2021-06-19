package straightWithoutBdd.ui.tests.codingchallenges;

import io.cucumber.java.nl.Stel;
import org.testng.annotations.Test;
import utils.Loggable;

import javax.sql.rowset.spi.SyncFactoryException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class CountingVowels implements Loggable {

    @Test
    public void test(){
        int ct = getCount("moon");
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


        for (int i=0;i<=str.length()-1;i++){
            if (vSet.contains(str.charAt(i))){
                vowelsCount++;
            }

        }
        return vowelsCount;
    }

}