import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int n = 0, ma; //Holds number of processes and memory available
        int i;
        int tm;
        int nob, temp = 0;
        int p = 0;
        char ch = 'y';
        int bs;
        int[] mp = new int[20];
        int ef;
        int ifrag;
        int tif = 0;
        int tef = 0;
        int lowest = 10000;
        int highest=0;
        int choice = 0;
        int[] max = new int[25];
        int[] b = new int[max.length];
        int[] f = new int[max.length];
        int[] bf = new int[max.length];
        int[] ff = new int[max.length];
        int j = 0, nof;
        int[] bt =new int[20];
        int[] wt=new int[20];
        int[] tat=new int [20];
        float wtavg, tatavg;
        int[] O=new int[20];


        Scanner Mike = new Scanner(System.in);

        //Displaying to the user and asking for input from the user.
        System.out.println("A program that displays various memory techniques");

        System.out.println("1.Multiprogramming with fixed variables");
        System.out.println("2.Multiprogramming with various variables");
        System.out.println("3.Worst fit Management Technique");
        System.out.println("4.Best fit Management Technique");
        System.out.println("5.First Fit Management Technique");
        System.out.println("6.Paging Technique");
        System.out.println("7.FCFS CPU SCHEDULING ALGORITHM");
        System.out.println("8.SJF CPU SCHEDULING ALGORITHM");
        System.out.println("9.ROUND ROBIN CPU SCHEDULING ALGORITHM");
        System.out.println("10.PRIORITY CPU SCHEDULING ALGORITHM");
        System.out.println("11.Multi Level Queue Scheduling Algorithm");
        System.out.println("12.FCFS Disk scheduling Alforithm");
        System.out.println("13.Scan Disk Scheduling ALgorithm");
        System.out.println("14.C-Scan Disk Scheduling ALgorithm");
        System.out.println("15.Bankers Algorithm for deadlock avoidance");

        System.out.println("Please select the technique you would like to implement");
        choice = Mike.nextInt();

        // A loop that prompts the user if a wrong choice is made and ask to make the right choice.
        while (choice<1 || choice>=20) {
            System.out.println("Please your choice is invalid");
            System.out.println("TRY AGAIN");
            System.out.println("Please select the technique you would like to implement");
            choice = Mike.nextInt();
        }

             //Memory management technique with fixed variables
            if (choice == 1) {


            System.out.print("Enter the total memory available (in Bytes) -- ");//Ask user for memory available
            ma = Mike.nextInt();

            System.out.print("Enter the block size (in Bytes) -- "); // Ask user for block size
            bs = Mike.nextInt();

            nob = ma / bs; //Calculating number of blocks
            ef = ma - nob * bs;  // Calculating external fragmentation

            System.out.print("\nEnter the number of processes -- "); // Ask fir nuber of processes
            n = Mike.nextInt();

              //  loop to store memory required values into the mp array variable
            for (i = 0; i < n; i++) {
                System.out.print("Enter memory required for process " + (i + 1) + " (in Bytes)-- ");
                mp[i] = Mike.nextInt();
            }
            System.out.print("\nNo. of Blocks available in memory -- " + nob);

            System.out.print("\n\nPROCESS\tMEMORY REQUIRED\t ALLOCATED\tINTERNAL FRAGMENTATION");

             //// A loop that displays the process required and calculates the total internal fragmentation

            for (i = 0; i < n && p < nob; i++) {
                System.out.print("\n   " + (i + 1) + "   \t\t    " + mp[i]);
                if (mp[i] > bs) {
                    System.out.print("\t\t     NO \t\t---");
                } else {
                    System.out.print("\t\t    YES     \t" + (bs - mp[i]));
                    tif = tif + bs - mp[i];
                    p++;
                }
            }
            if (i < n) {
                System.out.print("\nMemory is Full, Remaining Processes cannot be accomodated");
            }
            System.out.print("\n\nTotal Internal Fragmentation is " + tif);
            System.out.print("\nTotal External Fragmentation is " + ef);

        //Management technique with various variables
        } else if (choice == 2) {

            System.out.print("\nEnter the total memory available (in Bytes)-- ");//Ask user for input of memory available
            ma = Mike.nextInt();

            temp = ma;

            //A loop that will determine if memory is full.

            for (i = 0; ch == 'y'; i++, n++) {
                System.out.print("\nEnter memory required for process " + (i + 1) + " (in Bytes) -- ");
                mp[i] = Mike.nextInt();

                if (mp[i] <= temp) {
                    System.out.print("\nMemory is allocated for Process " + (i + 1) + " ");
                    temp = temp - mp[i];

                    System.out.println("Do you want to continue(y/n)");
                    ch = Mike.next().charAt(0);

                }
            } System.out.println("\n\nTotal Memory Available " + ma);

                System.out.println("\n\n\tPROCESS\t\t MEMORY ALLOCATED ");

                // loop to display memory require for processing
                for(i = 0; i < n; i++){
                    System.out.println("\n \t%d\t\t%d"+ i+1 + mp[i]);
                }

                // display allocated memory ma - temp which holds the memory size value).
                int tma=ma - temp;//Total Memory Allocated calculation.

                System.out.println("Total Memory Allocated is " + tma);
                System.out.println("Total External Fragmentation is " + temp);


         //Worst Fit Management technique
        } else if (choice == 3) {


            System.out.println("Enter the number of blocks"); //Ask user for input
            nob = Mike.nextInt();

            System.out.println("Enter the number of files");//Ask user for input
            nof = Mike.nextInt();

            System.out.println("Enter the size of the blocks");//Ask user for input

                //A loop that stores the number of blocks
            for (i = 1; i <= nob; i++) {
                System.out.println("Block:" + i);
                b[i] = Mike.nextInt();
            }
            System.out.println("Enter the size of files");//Asking user for input
                //A loop that stores the number of files
            for (i = 1; i <= nof; i++) {
                System.out.println("File" + i);
                f[i] = Mike.nextInt();
            }
            for (i = 1; i <= nof; i++) {
                for (j = 1; j <= nob; j++) {
                    if (bf[j] != 1) {
                        temp = b[j] - f[i];
                        if (temp >= 0) {
                            ff[i] = j;
                            break;
                        }
                    }
                }

                f[i] = temp;
                bf[ff[i]] = 1;

            }
            System.out.println("\nFile_no\tFile_size \tBlock_no\tBlock_size\tFragment");//Displays table to user
            for (i = 1; i <= nof; i++)

                System.out.println(i + "\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + f[i]);

            //Best Fit Technique

        } else if (choice == 4) {

            System.out.println("Enter the number of blocks");
            nob = Mike.nextInt();

            System.out.println("Enter the number of files");
            nof = Mike.nextInt();

            System.out.println("Enter the size of the blocks");
            //A loop that stores the number of blocks
            for (i = 1; i <= nob; i++) {
                System.out.println("Block:" + i);
                b[i] = Mike.nextInt();
            }
            System.out.println("Enter the size of files");

            //A loop that stores the number of files
            for (i = 1; i <= nof; i++)
            {
                System.out.println("File" + i);
                f[i] = Mike.nextInt();
            }

               for (i = 1; i <= nof; i++)
               {
                for (j = 1; j <= nob; j++)
                {
                    if (bf[j] != 1)
                    {
                        temp = b[j] - f[i];

                        if (temp >= 0)

                            if (lowest > temp)
                            {
                                ff[i] = j;
                                lowest = temp;

                            }
                    }
                }

                ff[i] = lowest;
                bf[ff[i]] = 1;
                lowest = 10000;
            }

            System.out.println("\nFile_no\tFile_size \tBlock_no\tBlock_size\tFragment");//Displays a table to the user containing the respective values
            for (i = 1; i <= nof && ff[i]!=0; i++) {
                System.out.println(i + "\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + f[i]);
            }
        }else

            //First Fit Technique
            if(choice==5){

                System.out.println("Enter the number of blocks:");
                nob= Mike.nextInt();
                System.out.println("Enter the number of files:");
                nof= Mike.nextInt();
                System.out.println("Enter the size of the blocks:-\n");

                // A loop that stores the number of blocks.
                for(i=1;i<=nob;i++){
                    System.out.println("Block" + i);
                    b[i]= Mike.nextInt();
                }
                System.out.println("Enter the size of the files ");
                for(i=1;i<=nof;i++)
                {
                    System.out.println("File"+i);
                    f[i]= Mike.nextInt();
                }
                for(i=1;i<=nof;i++)
                //A loop storing the number of files
                {

                    for(j=1;j<=nob;j++)
                    {
                        if(bf[j]!=1) //if bf[j] is not allocated
                        {
                            temp=b[j]-f[i];
                            if(temp>=0)
                                if(highest<temp)
                                {
                                    ff[i]=j;
                                    highest=temp;
                                }
                        }
                    }
                    f[i]=highest;
                    bf[ff[i]]=1;
                    highest=0;
                }
                System.out.println("\nFile_no\tFile_size \tBlock_no\tBlock_size\tFragment");
                for (i = 1; i <= nof; i++) {
                    System.out.println(i + "\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + f[i]);
                }


            }else

                //Paging management technique.
                if(choice==6){

                    int[] s=new int[10];
                    int[][] fno=new int[10][20];
                    int x; //stores the process number
                    int y;  //Stores the paging number
                    int ps;  //Stores the pages size
                    int pa;  //Stores Page available
                    int nop;  //Stores the number  of pages
                    int rempages;
                    int ms;        //Stores the memory size
                    int offset;     //Stores the offset.

                    System.out.println("Enter the memory size  ");
                    ms = Mike.nextInt();

                    System.out.println("Enter the page size");
                    ps = Mike.nextInt();

                    nop = ms/ps; //Calculating the number pages.

                    System.out.println("The no. of pages available in memory are  " + nop);
                    System.out.println("Enter number of processes");
                    n = Mike.nextInt();
                    rempages = nop;

                    for(i=1;i<=n;i++)
                    {
                        System.out.println("Enter no. of pages required for p "+i);
                        s[i] = Mike.nextInt();
                        if(s[i] >rempages)
                        {
                            System.out.println("Memory is Full");
                            break;
                        }
                        rempages = rempages - s[i];
                        System.out.printf("Enter pagetable for p[%d] --- ",i);
                        for(j=0;j<s[i];j++)
                            fno[i][j] = Mike.nextInt();
                    }
                    System.out.println("Enter Logical Address to find Physical Address ");
                    System.out.println("Enter process no. ");
                    x = Mike.nextInt();

                    System.out.println("Enter page number ");
                    y = Mike.nextInt();

                    System.out.println("Enter offset ");
                    offset = Mike.nextInt();

                    if(x>n || y>=s[i] || offset>=ps)
                        System.out.println("Invalid Process or Page Number or offset");
                    else
                    {
                        pa=fno[x][y]*ps+offset;
                        System.out.println("The Physical Address is "+ pa);


                    }
                }else
                    if(choice==7){

                        ;
                        System.out.println("Enter the number of processes");
                        n= Mike.nextInt();

                        for(i=0;i<n;i++)
                        {
                            System.out.println("Enter Burst Time for Process"+ " " + i);
                            bt[i]= Mike.nextInt();
                        }
                        wt[0] = (int) (wtavg = 0);
                        tat[0] = (int) (tatavg = bt[0]);

                        for(i=1;i<n;i++)
                        {
                            wt[i] = wt[i-1] +bt[i-1];
                            tat[i] = tat[i-1] +bt[i];
                            wtavg = wtavg + wt[i];
                            tatavg = tatavg + tat[i];
                        }
                        System.out.println("\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");

                        for(i=0;i<n;i++)
                            System.out.println("\t\t"+i+"\t"+"\t\t"+bt[i]+"\t\t\t"+ wt[i]+"\t\t\t\t\t"+ tat[i]);

                        System.out.println("\nAverage Waiting Time" +" "+wtavg/n);
                        System.out.println("\nAverage Turnaround Time" + " "+ tatavg/n);


                    }else
                        if (choice==8){



                            System.out.println("Enter the number of processes");
                            n= Mike.nextInt();

                            int[] x = new int[20];
                            for(i=0; i<n; i++)
                            {
                                x[i]=i;
                                System.out.println("Enter Burst Time for Process"+""+ i);
                                bt[i]=Mike.nextInt();
                            }
                            int k;
                            for(i=0; i<n; i++)
                                for(k=i+1;k<n;k++)
                                    if(bt[i]>bt[k])
                                    {
                                        temp=bt[i];
                                        bt[i]=bt[k];
                                        bt[k]=temp;
                                        temp=x[i];
                                        x[i]=x[k];
                                        x[k]=temp;
                                    }

                            wt[0] = (int) (wtavg = 0);

                            tat[0] = (int) (tatavg = bt[0]);
                            for(i=1;i<n;i++)
                            {
                                wt[i] = wt[i-1] +bt[i-1];
                                tat[i] = tat[i-1] +bt[i];
                                wtavg = wtavg + wt[i];
                                tatavg = tatavg + tat[i];
                            }
                            System.out.println("\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");
                            for(i=0;i<n;i++)
                                System.out.println("\t\t"+i+"\t"+"\t\t"+bt[i]+"\t\t\t"+ wt[i]+"\t\t\t\t\t"+ tat[i]);

                            System.out.println("Average Waiting Time" +" "+wtavg/n);
                            System.out.println("Average Turnaround Time" + " "+ tatavg/n);

                        }else
                            if(choice==9){


                                int maxi;
                                int t;
                                int[] ct=new int[10];

                                float awt=0,att=0;

                                System.out.println("Enter the no of processes");
                                n= Mike.nextInt();

                                for(i=0;i<n;i++)
                                {
                                    System.out.println("Enter Burst Time for process" +""+ i);
                                    bt[i]= Mike.nextInt();
                                    ct[i]=bt[i];
                                }
                                System.out.println("Enter the size of time slice ");
                                t= Mike.nextInt();
                                maxi=bt[0];
                                for(i=1;i<n;i++)

                                    if(maxi<bt[i])

                                        maxi=bt[i];

                                for(j=0;j<(maxi/t)+1;j++)

                                    for(i=0;i<n;i++)

                                        if(bt[i]!=0)

                                            if(bt[i]<=t)
                                            {
                                                tat[i]= (int) (temp+bt[i]);

                                                temp=temp+bt[i];

                                                bt[i]=0;
                                            }
                                            else
                                            {
                                                bt[i]=bt[i]-t;

                                                temp=temp+t;
                                            }
                                for(i=0;i<n;i++)
                                {
                                    wt[i]=tat[i]-ct[i];

                                    att+=tat[i];

                                    awt+=wt[i];
                                }
                                System.out.println("The Average Turnaround time is"+" "+att);
                                System.out.println("The Average Waiting time is"+ ""+ awt/n);

                                System.out.println("\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");
                                for(i=0;i<n;i++)
                                    System.out.println("\t\t"+i+"\t"+"\t\t"+ct[i]+"\t\t\t"+ wt[i]+"\t\t\t\t\t"+ tat[i]);


                            }else
                                if(choice==10){


                                    int[] pri=new int[20];
                                    int k;


                                    System.out.println("Enter the number of processes");
                                    n=Mike.nextInt();
                                    for(i=0;i<n;i++)
                                    {
                                        O[i] = i;
                                        System.out.println("Enter the Burst Time & Priority of Process" + " "+i);
                                        bt[i]= Mike.nextInt();
                                        pri[i]=Mike.nextInt();
                                    }
                                    for(i=0;i<n;i++)
                                        for(k=i+1;k<n;k++)
                                            if(pri[i] > pri[k])
                                            {
                                                temp=O[i];
                                                O[i]=O[k];
                                                O[k]=temp;
                                                temp=bt[i];
                                                bt[i]=bt[k];
                                                bt[k]=temp;
                                                temp=pri[i];
                                                pri[i]=pri[k];
                                                pri[k]=temp;
                                            }
                                    wtavg = wt[0] = 0;
                                    tatavg = tat[0] = bt[0];

                                    for(i=1;i<n;i++)
                                    {
                                        wt[i] = wt[i-1] + bt[i-1];
                                        tat[i] = tat[i-1] + bt[i];
                                        wtavg = wtavg + wt[i];
                                        tatavg = tatavg + tat[i];
                                    }
                                    System.out.println("PROCESS\t\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
                                    for(i=0;i<n;i++)
                                        System.out.println(O[i] +"\t\t\t\t"+pri[i]+"\t\t\t"+bt[i]+ "\t\t\t"+wt[i]+"\t\t\t"+tat[i]);
                                    System.out.println("\nAverage Waiting Time is" +" "+ wtavg/n);
                                    System.out.println("\nAverage Turnaround Time is" + " "+ tatavg/n);
                                }else
                                    if(choice==11){


                                        int[] su= new int[20];



                                        System.out.println("Enter the number of processes --- ");
                                        n= Mike.nextInt();
                                        for(i=0;i<n;i++)
                                        {
                                            O[i] = i;
                                            System.out.println("Enter the Burst Time of Process"+ " "+ i);
                                            bt[i]= Mike.nextInt();
                                            System.out.println("System/User Process (0/1) ? --- ");
                                            su[i]= Mike.nextInt();
                                        }
                                        int k;
                                        for(i=0; i<n; i++)
                                            for(k=i+1;k<n;k++)
                                                if(su[i] > su[k])
                                                {
                                                    temp=O[i];
                                                    O[i]=O[k];
                                                    O[k]=temp;
                                                    temp=bt[i];
                                                    bt[i]=bt[k];
                                                    bt[k]=temp;
                                                    temp=su[i];
                                                    su[i]=su[k];
                                                    su[k]=temp;
                                                }
                                        wtavg = wt[0] = 0;
                                        tatavg = tat[0] = bt[0];
                                        for(i=1;i<n;i++)
                                        {
                                            wt[i] = wt[i-1] + bt[i-1];
                                            tat[i] = tat[i-1] + bt[i];

                                            wtavg = wtavg + wt[i];
                                            tatavg = tatavg + tat[i];
                                        }
                                        System.out.println("PROCESS\t\t SYSTEM/USER PROCESS \tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
                                        for(i=0;i<n;i++)
                                            System.out.println(O[i]+"\t\t\t\t"+su[i]+"\t\t\t\t\t\t"+bt[i]+"\t\t\t\t"+wt[1]+"\t\t\t\t"+tat[i]);
                                        System.out.println("Average Waiting Time is"+" "+wtavg);
                                        System.out.println("Average Turnaround Time is"+ " "+tatavg);


                                    }else
                                        if(choice==12){
                                            int[] t = new int[20];
                                            int not; //No of tracks
                                            int[] tohm=new int [20];
                                            int tot=0;
                                            float avhm = 0;

                                            System.out.println("Enter the no.of tracks");
                                            not= Mike.nextInt();
                                            System.out.println("Enter the tracks to be traversed");
                                            for(i=2;i<not+2;i++)
                                                t[i] = Mike.nextInt();

                                            for(i=1;i<not+1;i++)
                                            {
                                                tohm[i]=t[i+1]-t[i];
                                                if(tohm[i]<0)
                                                    tohm[i]=tohm[i]*(-1);
                                            }
                                            for(i=1;i<not+1;i++) {
                                                tot += tohm[i];
                                                avhm = (float) tot / not;
                                                System.out.println("Tracks traversed\tDifference between tracks\n");

                                                for(i=1;i<not+1;i++)
                                                System.out.println("\t\t"+t[i] +"\t\t\t"+ tohm[i]);
                                            }

                                            System.out.println("\nAverage header movements:"+ avhm);





        }else
            if(choice==13){
                int[] t=new int[20];
                int[] d=new int[20]; int h, k;
                int[] atr=new int[20];
                int tot, sum=0;

                System.out.println("enter the no of tracks to be traveresed");
                int not = Mike.nextInt();
                System.out.println("enter the position of head");
                h= Mike.nextInt();
                t[0]=0;t[1]=h;
                System.out.println("enter the tracks");
                for(i=2;i<n+2;i++)
                    t[i]= Mike.nextInt();
                for(i=0;i<n+2;i++)
                {
                    for(j=0;j<(n+2)-i-1;j++)
                    { if(t[j]>t[j+1])
                    {
                        temp=t[j];
                        t[j]=t[j+1];
                        t[j+1]=temp;
                    } } }
                for(i=0;i<n+2;i++)
                    if(t[i]==h)
                        j=i;k=i;
                p=0;
                while(t[j]!=0)
                {
                    atr[p]=t[j];
                    j--;
                    p++;
                }
                atr[p]=t[j];
                for(p=k+1;p<n+2;p++,k++)
                    atr[p]=t[k+1];
                for(j=0;j<n+1;j++)
                {
                    if(atr[j]>atr[j+1])
                        d[j]=atr[j]-atr[j+1];
                    else
                        d[j]=atr[j+1]-atr[j];
                    sum+=d[j];

                    System.out.println("Tracks traversed\tDifference between tracks\n");

                }
                System.out.println("\nAverage header movements:" + (float)sum/n);

            }

    }



    }
