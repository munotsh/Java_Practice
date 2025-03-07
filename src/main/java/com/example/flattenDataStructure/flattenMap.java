package com.example.flattenDataStructure;

import java.util.HashMap;
import java.util.Map;

public class flattenMap {
//    Flatten it into a map where the keys in the map
//    represent the concatenation of the field names that
//    represent the full path to the
Map<String, String> flattenMap(Map<String,Object> input){
    Map<String, String> res = new HashMap<>();
    flattenMapHelper(input, "",res);
    return res;
}
    private void flattenMapHelper(Map<String,Object> input, String  prefix,Map<String, String> res ){

        for(String key: input.keySet()){
            String currkey = prefix.length()==0? key:prefix+"."+key;
            if(input.get(key) instanceof String){
                res.put(currkey,(String) input.get(key));
            }else{
                flattenMapHelper((Map<String,Object>)input.get(key), currkey, res);
            }
        }
    }

    public static void main(String[] args) {
        Map<String,Object> add = new HashMap<>();
        add.put("add1","999 x maxwell");
        add.put("add2", "manhattan");
        add.put("srate", "NB");

        Map<String,String> dadd = new HashMap<>();
        dadd.put("email","cc@gmail.com");
        add.put("digiadd",dadd);
        Map<String,Object> map = new HashMap<>();
        map.put("address",add);
        map.put("first","cc");
        System.out.println(new flattenMap().flattenMap(map));
        ;
    }
}

//output:
// {
//      address.digiadd.email=cc@gmail.com,
//      address.srate=NB,
//      address.add2=manhattan,
//      first=cc,
//      address.add1=999 x maxwell
//  }
