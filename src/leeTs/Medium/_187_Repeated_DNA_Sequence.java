package leeTs.Medium;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class _187_Repeated_DNA_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();
		System.out.println(0x111);
	}
	
	/* there is only four distinct character, so we can twenty
    bit to hash the string, each character two bit, so we just
    need to keep track of their hashed integer rather than the
    whole string*/
    public List<String> findRepeatedDnaSequencesSlidingHashing(String s) {
        List<String> result = new ArrayList<>();
        if(10 > s.length())
            return result;
        HashSet<Integer> track = new HashSet<>();
        HashSet<Integer> added = new HashSet<>();
        int hashNum = 0;// we have 31 > 20 bit
        char[] mapping = new char[26];
        mapping['C' - 'A'] = 1;
        mapping['G' - 'A'] = 2;
        mapping['T' - 'A'] = 3;
        int i = 0;
        for(; i < 9; i ++) {
            hashNum <<= 2;//for this two bits
            hashNum |= mapping[s.charAt(i) - 'A'];
        }
        for(; i < s.length(); i ++) {
            hashNum &= 0x3FFFF;//erase the top
            hashNum <<= 2;
            hashNum |= mapping[s.charAt(i) - 'A'];// form a new hash by sliding
            if(!track.add(hashNum))
                if(added.add(hashNum))// avoiding duplications
                    result.add(s.substring(i - 9, i + 1));
        }
        return result;
    }
	
	// Naive and violent it seems to be, not as bad as imagine though
	public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        HashSet<String> track = new HashSet<>();
        String candidate = null;
        for(int i = 0; i < s.length() - 9; i ++) {
            candidate = s.substring(i, i + 10);
            if(track.contains(candidate))
                result.add(candidate);
            else
                track.add(candidate);
        }
        return new ArrayList<String>(result);
    }
	

}
