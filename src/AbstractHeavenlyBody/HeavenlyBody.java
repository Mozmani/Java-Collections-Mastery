package AbstractHeavenlyBody;


import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bT) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, bT);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody heavenlyBody){
        return satellites.add(heavenlyBody);
    }


    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        HeavenlyBody compareObj = (HeavenlyBody) obj;
        return compareObj.getKey().equals(this.key);
    }

    @Override
    public final int hashCode() {
        System.out.println("hashcode called");
        return this.getKey().hashCode() + 57;
    }

    public static Key makeKey(String name, BodyTypes bodyTypes){
        return new Key(name, bodyTypes);
    }

    @Override
    public String toString(){
        // name: bodyType, orbitalPeriod

        return this.getKey().getName() + ": "+ this.getKey().getBodyType() + ", " + this.orbitalPeriod;
    }

    public enum BodyTypes {PLANET, DWARF_PLANET, MOON};

    public static class Key{
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyType = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }



        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }

            System.out.println("obj.getClass() is " + obj.getClass());
            System.out.println("this.getClass() is " + this.getClass());
            if ((obj == null) || (obj.getClass() != this.getClass())) {
                return false;
            }

            Key compareObj = (Key) obj;

            if (compareObj.getName() == this.name && compareObj.getBodyType() == this.bodyType) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 57;
        }

        @Override
        public String toString(){
            return name + ": " + bodyType;
        }
    }
}