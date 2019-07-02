#include <iostream>
using namespace std;

void subsetBinary(int digits,string prefix=""){
    if(digits==0){
        cout<<prefix<<endl;
    }
    else{
        subsetBinary(digits-1,prefix+"0");
        subsetBinary(digits-1,prefix+"1");
    }
}

int main(){
    subsetBinary(3);
    return 0;
}