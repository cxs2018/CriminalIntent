package com.cuixuesen.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    // 以空间换时间
    private TreeMap<UUID, Integer> mTable;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        mTable = new TreeMap();
//        for (int i = 0; i < 100; i++) {
//            Crime crime = new Crime();
//            crime.setTitle("Crime #" + i);
//            crime.setSolved(i % 2 == 0);
//            crime.setRequiresPolice(i % 2 == 0);
//            mCrimes.add(crime);
//            mTable.put(crime.getId(), (Integer) mCrimes.size() - 1);
//        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime: mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
//        return mCrimes.get(mTable.get(id));
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public void removeCrime(Crime c) {
        mCrimes.remove(c);
    }
}
