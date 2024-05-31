class GFG
{
static void towerOfHanoi(int n, char from_rod, char to_rod,char aux_rod)
{
if(n==1)
{system.out.println("move disk 1 from rod" + from_rod + "to rod" + to_rod);
return;
}

towerOfHanoi(n-1,from_rod,aux_rod,to_rod);
system.out.println("move disk" + n + "from rod" + from_rod + "to rod" + to_rod);
towerOfHanoi(n-1,aux_rod,to_rod,from_rod);
}

public static void main(string args[])
{
int n = 4;
towerOfHanoi(n,'A\','C\','B\');
}
}