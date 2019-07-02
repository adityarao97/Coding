#include <iostream>
using namespace std;

void TowerOfHanoi(int n,int fromPeg,int toPeg,int auxPeg){
    if(n==1){
        cout<<"Move 1st disk from " << fromPeg << " to " << toPeg<<endl;
    }
    else{
        TowerOfHanoi(n-1,fromPeg,auxPeg,toPeg);
        cout<<"Move " << n << " disk from " << fromPeg << " to " << toPeg<<endl;
        TowerOfHanoi(n-1,auxPeg,toPeg,fromPeg);
    }
}

int main(){
    TowerOfHanoi(3,1,2,3);
    return 0;
}

