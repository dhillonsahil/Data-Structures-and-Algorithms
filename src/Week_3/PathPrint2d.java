package Week_3;
public class PathPrint2d {
    public static void main(String[] args) {
        int dest[]={2,2};
        pathPrint(0, 0, dest, "");
    }
    public static void pathPrint(int cc,int r, int dest[],String path){
        if(cc > dest[0] || r>dest[1]){
            return ;
        }
        if(cc ==dest[0] && r == dest[1]){
            System.out.println(path);
            return;
        }
        pathPrint(cc+1,r, dest, path+"H");
        pathPrint(cc,r+1, dest, path+"V");
    }
}
