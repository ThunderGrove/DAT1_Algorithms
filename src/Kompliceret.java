import timer.MyTimer;

public class Kompliceret{
    public static void main(String[]args){
        int[]o={100,20,33,14,15,36,73,213,789,123,312,414,512,432,453,132,321,456,963,1234567890,51,1,0,2,9,3,8,4,7,5,6,10,123456789,987654321,987,8642,2468,421,124,9713,1397,7139,9317,3179,7931,
                852654,258456,456258,654258,456852,654852,9856,8569,5698,6985,9658,6589,5896,8965,753159,159753,159357,753951,752259,952257,158853,358851,9874123,3214789,1236987,7896321,4862,8624,
                6248,2486,4862,8426,4268,2684,6842,255,256,128,127,-963,-852,-741,-147,-258,-369,-789,-456,-123,-987,-654,-321,-9874123,-87412369,-74123698,-41236987,-12369874,-2369874,-36987412,
                -69874123,-96321478,-63214789,-32147896,-2147896,-14789632,-47896321,-78963214,-89632147,84265,42685,26845,684265,86245,62485,24865,48625,990,-990,991,-991,992,-992,993,-993,994,
                -994,995,-995,996,-996,997,-997,998,-998,999,-999
        };
        int n=20;
        int counter=0;
        long resultat=0;
        // Denne algoritme tager meget lang tid at gennemføre, og har en algoritmisk kompleksitet på O(N^2)

        /*for(int i=10;i<n+10;i++){
            MyTimer.start();
            counter++;
            for(int j=0;j<counter;j++){
                System.out.print(".");
            }
            for(int j=1;j<=Math.pow(2,i);j++){
                resultat=i;
            }
            System.out.print(" ");
            MyTimer.stop();
        }
        System.out.println("Resultat "+resultat);*/

        //ShellSort
        int[]v=o;
        n=v.length;
        int range=n/2;
        int i,j,temp;
        int gap;
        MyTimer.start();
        while(range>0){
            for(i=range;i<n;i++){
                temp=v[i];
                j=i;
                gap=j-range;
                while(j>=range&&v[gap]>temp){
                    v[j]=v[gap];
                    j-=range;
                    gap=j-range;
                    System.out.print(".");
                }
                v[j]=temp;

            }
            range/=2;
        }
        MyTimer.stop();


        System.out.print("Result: ");
        for(int k=0;k<v.length;k++) {
            System.out.print(v[k]+" ");
        }
        System.out.println(" ");

        //InsertionSort
        v=o;
        n=v.length;
        MyTimer.start();
        for(i=1;i<n;i++){
            temp=v[i];
            j=i-1;
            while(j>=0&&v[j]>temp){
                v[j+1]=v[j];
                j--;
            }
            System.out.print(".");
            v[j + 1]=temp;
        }
        MyTimer.stop();

        System.out.print("Result: ");
        for(int k=0;k<v.length;k++) {
            System.out.print(v[k]+" ");
        }
        System.out.println(" ");

        //MergeSort
        v=o;
        MyTimer.start();
        mergeSort(v,0,v.length-1);
        MyTimer.stop();

        System.out.print("Result: ");
        for(int k=0;k<v.length;k++) {
            System.out.print(v[k]+" ");
        }
        System.out.println(" ");
    }

    private static void mergeSort(int[]v,int low,int high){
        if(low<high){
            int middle=(low+high)/2;
            mergeSort(v,low,middle);
            mergeSort(v,middle+1,high);
            merge(v,low,middle,high);
        }
    }

    private static void merge(int[]v,int low,int middle,int high){
        int[]vAux=new int[v.length];
        for(int i=low;i<=high;i++) {
            vAux[i]=v[i];
        }
        int i=low;
        int j=middle+1;
        int k=low;
        while(i<=middle&&j<=high){
            if(vAux[i]<=vAux[j]){
                v[k]=vAux[i];
                i++;
            }else{
                v[k]=vAux[j];
                j++;
            }
            k++;
        }
        while(i<=middle){
            v[k]=vAux[i];
            k++;
            i++;
        }
        System.out.print(".");
    }
}