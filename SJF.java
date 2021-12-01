import java.util.*;
public class SJF{//Rahen Mohammed Qader Marroof
  public static void main(String[]args){
    Scanner sc=new Scanner (System.in);
    int a=4;
    int finishP[]=new int [a];
    int burst[]=new int [a];
    int start[]=new int [a];
    int arrive[]=new int [a];
    int finishT[]={0,0,0,0};
    int SystemTime=0;
    for(int i=0;i<a;i++){
      System.out.println("enter the burst of p"+(i+1));
      burst[i]=sc.nextInt();
      System.out.println("enter the arrive of p"+(i+1));
      arrive[i]=sc.nextInt();
    }
    int miniIndex=0;
    int te=0;
    System.out.println();
    //
    for(int i=0;i<a;i++){
      int min=500;
      for(int j=0;j<a;j++){
      if(arrive[j]<=SystemTime&&finishT[j]==0&&burst[j]<min){
        min = burst[j];
        miniIndex=j;
        }
      }
      finishP[miniIndex]=SystemTime+burst[miniIndex];
      start[miniIndex]=SystemTime;
      SystemTime=SystemTime+burst[miniIndex];
      finishT[miniIndex]=1;
    }
    float result=0;
    System.out.println("\n P    arrive  burst   finish  ");
    for(int i=0;i<a;i++)
    System.out.println("p"+(i+1)+"\t"+arrive[i]+"\t"+ burst[i]+"\t"+finishP[i]);
    for(int i=0;i<a;i++){
      System.out.println("wating time of p"+(i+1)+" = "+ (start[i]-arrive[i]));
      result=result+(start[i]-arrive[i]);
    }
    System.out.println("the average of the waiting time is = "+(result/a));
    result=0;
    for(int i=0;i<a;i++){
      System.out.println("the turn around time for p"+(i+1)+" = "+ (finishP[i]-arrive[i]));
      result=result+(finishP[i]-arrive[i]);
    }
    System.out.println("the average of the turn around time is = "+(result/4));
    sc.close();
  }
}