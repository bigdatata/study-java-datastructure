//============================================================================
// Name        : helloc++.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
using namespace std;
#define FIND(struc,e) (size_t)&(((struc*)0)->e)
#define SECONDS_PRE_YEAR (60*60*24*365)
#define MIN(x,y) ((x)>(y))?(x):(y)

//
//void swap(int *p,int *q){
//		int *temp;
//		*temp=*p;
//		*p=*q;
//		*q=*temp;
//	}

//	char* StrA(){
//		static char str[]="hello world";
//		return str;
//	}
//	const char* StrB(){
//		char* str="hello world";
//		return str;
//	}

//	int max(int x,int y){
//		return x>y?x:y;
//	}
//template <typename T>
//class Operate{
//public:
//	static T add(T a,T b){
//		return a+b;
//	}
//	static T mul(T a,T b){
//		return a*b;
//	}
//	static T judge(T a,T b){
//		if(a>=0){
//			return a;
//		}else{
//			return a/b;
//		}
//	}
//};
//
//template <typename T,typename B>
//T add(T a,B b){
//	return a+b;
//}

//struct Test{
//	Test(int){
//
//	}
//	Test(){}
//	void fun(){}
//};

//class Cat {
//	public:
//		Cat(int age) :itsAge(age) {
//			howManyCats++;
//		}
//
//		virtual ~Cat() {
//			howManyCats--;
//		}
//
//
//		virtual int getItsAge() const {
//			return itsAge;
//		}
//
//		virtual void setItsAge(int itsAge) {
//			this->itsAge = itsAge;
//		}
//		static int getHowManyCats(){
//				return howManyCats;
//		}
//
//	private:
//		static int howManyCats;
//		int itsAge;
//
//	};
//int Cat::howManyCats=0;

//class Base {
//private:
//	int j;
//	int i;
//public:
//	Base(int i) :
//			j(i), i(j) {
//	}
//	Base() :
//			j(0), i(j) {
//	}
//
//	int getI() const {
//		return i;
//	}
//
//	int getJ() const {
//		return j;
//	}
//
//};

//class A{
//	static const int m=0;
//	//A():m(0){}
//};
int main() {

//	Base base(98);
//	cout<<base.getI()<<endl;
//	cout<<base.getJ()<<endl;
//	const int maxCats=5;
//	int i;
//	Cat* catHouse[maxCats];
//	for(i=0;i<maxCats;i++){
//		catHouse[i]=new Cat(i);
//	}
//	for(i=0;i<maxCats;i++){
//		cout<<"There are";
//		cout<<Cat::getHowManyCats();
//		cout<<"cats left!";
//		cout<<"Deleting the one which is";
//		cout<<catHouse[i]->getItsAge();
//		cout<<"years old\n";
//		delete catHouse[i];
//		catHouse[i]=0;
//	}
//	Test a(1);
//	a.fun();
//	Test b;//Test b(); error
//	b.fun();

//	cout<<Operate<int>::add(1,2)<<endl;
//	cout<<Operate<float>::add(1.1,2.2)<<endl;
//	cout<<add(5,4)<<endl;
//	cout<<add(5.4,4)<<endl;
//	cout<<add(5,4.4)<<endl;
	//int max(x,y);
//	int (*p)(int,int)=&max;
//	printf("Please input three integer\n");
//	fflush(stdout);
//	int a,b,c,d;
//	scanf("%d%d%d",&a,&b,&c);
//	d=(*p)((*p)(a,b),c);
//	printf("Among %d, %d, and %d,the maximal integer is %d\n",a,b,c,d);
//
//	int N;
//	int s,i,j;
//	int squa;
//	scanf("%d",&N);
//
//	int** a=(int**)malloc(N*N*sizeof(int));
//	if(a==NULL){
//		return 0;
//	}
//	for(i=0;i<N;i++){
//		if((a[i]=(int*)malloc(N*sizeof(int)))==NULL){
//			while(--i>=0){
//				free(a[i]);
//			}
//			free(a);
//			return 0;
//		}
//	}
//	squa=N*N;
//
////	for(i=0;i<N;i++){
////		for(j=0;j<N;j++){
////			s=i+j;
////			if(s<N){
////				a[i][j]=s*(s+1)/2+((s%2==0)?j:i);
////			}else{
////				s=(N-1-i)+(N-1-j);
////				a[i][j]=squa-s*(s+1)/2-(N-((s%2==0)?i:j));
////			}
////		}
////	}
//	for(i=0;i<N;i++){
//		for(j=0;j<N;j++){
//			a[i][j]=squa;
//		}
//	}
//
//	i=0;
//	j=0;
//	int k=1;
//	int derect=1;
//	while(k<squa){
//		switch(derect){
//		case 1:
//			if(j<N-1&&a[i][j+1]==squa){
//				a[i][j++]=k++;
//			}else{
//				derect=2;
//			}
//			break;
//		case 2:
//			if(i<N-1&&a[i+1][j]==squa){
//				a[i++][j]=k++;
//			}else{
//				derect=3;
//			}
//			break;
//		case 3:
//			if(j>0&&a[i][j-1]==squa){
//				a[i][j--]=k++;
//			}else{
//				derect=4;
//			}
//			break;
//		case 4:
//			if(i>0&&a[i-1][j]==squa){
//				a[i--][j]=k++;
//			}else{
//				derect=1;
//			}
//			break;
//		}
//	}
//	for(i=0;i<N;i++){
//		for(j=0;j<N;j++){
//			printf("%6d",a[i][j]);
//		}
//		printf("\n");
//	}

//	float a=1.0f;
//	cout<<(int)a<<endl;
//	cout<<&a<<endl;
//	cout<<(int&)a<<endl;
//	cout<<boolalpha<<((int)a==(int&)a)<<endl;
//	float b=0.0f;
//	cout<<(int)b<<endl;
//	cout<<&b<<endl;
//	cout<<(int&)b<<endl;
//	cout<<boolalpha<<((int)b==(int&)b)<<endl;
//	cout<<noboolalpha<<true<<endl;

//	printf("%d\n",sizeof(long double));
//	printf("%d\n",sizeof(long));
//	printf("%d\n",sizeof(double));
//	printf("%d\n",sizeof(float));
//	printf("%d\n",sizeof(int));
//	printf("%d\n",sizeof(char));
//	printf("%d\n",sizeof(bool));
//	printf("%d\n",sizeof(short));

//	unsigned char a=0xA5;
//	unsigned char b=~a>>4+1;
//
//	printf("b=%d\n",b);

//	int a=0x7fffffff,b=0xffffffff;
//	int d=0x80000000;
//	cout<<b<<endl<<d<<endl;
//	cout<<boolalpha<<(b>d)<<endl;
//	int c=a-b;
//	c= unsigned(c)>>(sizeof(int)*8-1);
//	cout<<c<<endl;

//	struct student{
//		int a;
//		char b[20];
//		double ccc;
//	};
//	cout<<FIND(student,a)<<endl;
//	cout<<FIND(student,b)<<endl;
//	cout<<FIND(student,ccc)<<endl;
//	cout<<sizeof(student)<<endl;

//	int i=SECONDS_PRE_YEAR;
//	cout<<i<<endl;

//	struct{
//		short a1;
//		short a2;
//		short a3;
//	}A;
//	struct{
//		double a1;
//		short a2;
//	}B;
//
//	char *ss1="0123456789";
//	char ss2[]="0123456789";
//	char ss3[100]="0123456789";
//	int ss4[100];
//	char q1[]="abc";
//	char q2[]="a\n";
//	char* q3="a\n";
//	char *str1=(char *)malloc(100);
//	void *str2=(void *)malloc(100);
//
//	cout<<sizeof(ss1)<<" ";
//	cout<<sizeof(ss2)<<" ";
//	cout<<sizeof(ss3)<<" ";
//	cout<<sizeof(ss4)<<" ";
//	cout<<sizeof(q1)<<" ";
//	cout<<sizeof(q2)<<" ";
//	cout<<sizeof(q3)<<" ";
//	cout<<sizeof(A)<<" ";
//	cout<<sizeof(B)<<" ";
//	cout<<sizeof(str1)<<" ";
//	cout<<sizeof(str2)<<" ";

//	int a;
//	char b;
//	int c;
//	printf("0x%08x ",&a);
//	printf("0x%08x ",&b);
//	printf("0x%08x ",&c);

//	class A5{
//	public:
//		double d;
//		float f;
//		int i;
//		char c;
//		A5();
//		~A5();
//	};
//	cout<<sizeof(A5)<<endl;

//	double** a[3][4];
//	cout<<sizeof(a)<<endl;

//	string strArr[]={"12","34","345"};
//	cout<<sizeof(string)<<endl;
//
//	const double maxWage=20.0;
//	const double *pc=&maxWage;
//	int a=10,b=20;
//	swap(&a,&b);
//	cout<<a<<" "<<b<<endl;

//
//	char *c="hello world";
//
//	cout<<StrA()<<endl;
//	cout<<StrB()<<endl;

	return 0;
}
