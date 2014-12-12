package zadaca;

public class zadatak1 {
	
public static void main(String[] args) {
	Datum[] nizDatuma=new Datum[50];

for(int i=0;i<50;i++){
	System.out.println(nizDatuma[i].toString());
}

bubbleSortDatum(nizDatuma);
System.out.println("\n\nSortirani niz datuma\n________________________");
for(int i=0;i<50;i++){
	System.out.println(nizDatuma[i].toString());
}
System.out.println("Sortirani datumi sa razmacima\n__________________");
ispisiDatumeIRazmak(nizDatuma);


}

/**
 * funkcija koja pravi i vraca niz Random Datuma
 * @return niz random Datuma
 */
public static Datum[] napraviNizRandomDatuma(){
	Datum[] nizDatuma=new Datum[50];

	int m,d,g=2014;;
	for (int i=0;i<50;i++){
		m=1 + (int)(Math.random() * ((12 - 1) + 1));
		if((m==1)||(m==3)||(m==5)||(m==7)||(m==8)||(m==10)||(m==12)){
			d=	1 + (int)(Math.random() * ((31 - 1) + 1));
			nizDatuma[i]=new Datum(d,m,g);
		}
		else if ((m==4)||(m==6)||(m==9)||(m==11)){
			d=1 + (int)(Math.random() * ((30 - 1) + 1));
			//Datum datum=new Datum(d,m,g);
			nizDatuma[i]=new Datum(d,m,g);
			}
		else {
			d=1 + (int)(Math.random() * ((28 - 1) + 1));
			nizDatuma[i]=new Datum(d,m,g);
			}
			}
	return nizDatuma;
	}
/**
 * funkcija koja prima niz datuma(niz elemenata tipa Datum), 
 * te ih sortira, od najstarijeg datuma do najnovijeg
 * @param nizDatuma niz elemenata tipa Datum
 * @return sortiran niz elemenata tipa Datum
 */
public static Datum[] bubbleSortDatum(Datum[] nizDatuma) {
    Datum temp;
    for(int i=0; i < nizDatuma.length-1; i++){
        for(int j=1; j < nizDatuma.length-i; j++){
            if((nizDatuma[j-1].compare(nizDatuma[j])==1)){
                temp=nizDatuma[j-1];
                nizDatuma[j-1] = nizDatuma[j];
                nizDatuma[j] = temp;
            }
        }
        
    }
    return nizDatuma;
    }

/**
 * funkcija koja prima niz datuma(niz elemenata tipa Datum), te ih ispisuje, zajedno sa podacima 
 * o tome koliko je proslo vremmena u danima od prethodnog datuma, odnosno koliko ima do sljedeceg dazum
 * @param datumi niz elemenatatipa Datum
 */
public static void ispisiDatumeIRazmak(Datum[] datumi){
	int razPre=0,razPos=0,razM=0;
	for(int i=0;i<50;i++){
		if(i==0){
			razPre=0;
			if(datumi[i+1].getMjesec()-datumi[i].getMjesec()>1){
				razM=datumi[i+1].getMjesec()-datumi[i].getMjesec();
				razPos=datumi[i+1].getDan()+(razM-1)*30+(30-datumi[i].getDan());
				System.out.println(datumi[i].toString()+", "+razPre+ " dana od prethodnog, " +razPos+" do sljedeceg");

			}
			else if (datumi[i+1].getMjesec()-datumi[i].getMjesec()==1){
				razPos=datumi[i+1].getDan()+(30-datumi[i].getDan());
				System.out.println(datumi[i].toString()+", "+razPre+ " dana od prethodnog, " +razPos+" do sljedeceg");
			}
			else{
			razPos=datumi[i+1].getDan()-datumi[i].getDan();
			System.out.println(datumi[i].toString()+", "+razPre+ " dana od prethodnog, " +razPos+" do sljedeceg");
			}
		}
		else if(i==49){
			razPos=0;
			if(datumi[i].getMjesec()-datumi[i-1].getMjesec()>1){
				razM=datumi[i].getMjesec()-datumi[i-1].getMjesec();
				razPre=datumi[i].getDan()+(razM-1)*30+(30-datumi[i-1].getDan());
				System.out.println(datumi[i].toString()+", "+razPre+ " dana od prethodnog, " +razPos+" do sljedeceg");
				}
			else if (datumi[i].getMjesec()-datumi[i-1].getMjesec()==1){
				razPre=datumi[i].getDan()+(30-datumi[i-1].getDan());
				System.out.println(datumi[i].toString()+", "+razPre+ " dana od prethodnog, " +razPos+" do sljedeceg");
			}
			else {
			razPre=datumi[i].getDan()-datumi[i-1].getDan();
			System.out.println(datumi[i].toString()+", "+razPre+" dana od prethodnog, " +razPos+" do sljedeceg");
	}
			}
		else{
			if(datumi[i].getMjesec()-datumi[i-1].getMjesec()>1){
				razM=datumi[i].getMjesec()-datumi[i-1].getMjesec();
				razPre=datumi[i].getDan()+(razM-1)*30+(30-datumi[i-1].getDan());
				}
			else if (datumi[i].getMjesec()-datumi[i-1].getMjesec()==1){
				razPre=datumi[i].getDan()+(30-datumi[i-1].getDan());
			}
			else {
			razPre=datumi[i].getDan()-datumi[i-1].getDan();
	}
			if(datumi[i+1].getMjesec()-datumi[i].getMjesec()>1){
				razM=datumi[i+1].getMjesec()-datumi[i].getMjesec();
				razPos=datumi[i+1].getDan()+(razM-1)*30+(30-datumi[i].getDan());

			}
			else if (datumi[i+1].getMjesec()-datumi[i].getMjesec()==1){
				razPos=datumi[i+1].getDan()+(30-datumi[i].getDan());
			}
			else{
			razPos=datumi[i+1].getDan()-datumi[i].getDan();
			}
			System.out.println(datumi[i].toString()+", "+razPre+ " dana od prethodnog, " +razPos+" do sljedeceg");

		}
			
	}
}
}

