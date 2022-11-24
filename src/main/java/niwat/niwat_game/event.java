package niwat.niwat_game;
public class event {
    public static boolean checkHit(Dog dog,Wave wave) {
        if(dog.x+dog.dogSize>wave.x && dog.x<wave.x) {
            if(dog.y+dog.dogSize>=wave.y-wave.height) {
            	System.out.println("Hit");
            	return true;
            }
        }
    return false;
    }
    public static boolean checkHit1(Dog dog,BoneItem1 wave) {
        if(dog.x+dog.dogSize>wave.x && dog.x<wave.x) {
            if(dog.y+dog.dogSize>=wave.y-wave.height) {
            	System.out.println("Point 1");
            	return true;
            }
        }  
    return false;
    }
    public static boolean checkHit2(Dog dog,BoneItem2 wave) {
        if(dog.x+dog.dogSize>wave.x && dog.x<wave.x) {
            if(dog.y+dog.dogSize>=wave.y-wave.height) {
            	System.out.println("Point 2");
            	return true;
            }
        }  
    return false;
    }
}