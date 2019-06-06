package com.javarush.task.task35.task3507;

/*
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
//        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
//        System.out.println(allAnimals);
    }

//    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, NoSuchMethodException {
//       ClassLoader loader = new ClassLoader() {
//           @Override
//           public Class<?> loadClass(String name) throws ClassNotFoundException {
//               return super.loadClass(name);
//           }
//       };
//
//        File rootFile = new File(pathToAnimals);
//        File [] list = rootFile.listFiles();
//
//        for (File file : list) {
//            Class <?> myClass = loader.loadClass(file.toString());
//
//        }
//
////       return mySet;
//    }
}
