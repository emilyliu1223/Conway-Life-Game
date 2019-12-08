package edu.neu.coe.info6205.life.base;



	import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.jenetics.BitChromosome;
	import io.jenetics.BitGene;
	import io.jenetics.Genotype;
	import io.jenetics.engine.Engine;
	import io.jenetics.engine.EvolutionResult;
	import io.jenetics.util.Factory;
import io.jenetics.util.RandomRegistry;
	 
	public class Life {
		private static final String LIFE = "@";
	    private static final String DEATH = ".";
	    // 2.) Definition of the fitness function.
	    private static int eval(Genotype<BitGene> gt) {
	        return gt.getChromosome()
	            .as(BitChromosome.class)
	            .bitCount();
	    }
	  
	    
	    
	    
	    
	    public static void main(String[] args) {

	        Factory<Genotype<BitGene>> gtf =
	            Genotype.of(BitChromosome.of(100, 0.5),3);
  
	        Engine<BitGene, Integer> engine = Engine
	            .builder(Life::eval, gtf)
	            .build();
	 
	        Genotype<BitGene> result = engine.stream()
	            .limit(100)
	            .collect(EvolutionResult.toBestGenotype());
	         
	        System.out.println("\n" + result);
	       
	        List<Point> points=new ArrayList<Point>();
	        String[] g=result.toString().split("\\|");
	       
	        System.out.println(Arrays.toString(g));
	      

	        System.out.println(fit(g));
//	        for(int i=0;i<fit(g).size();i++) {
//	        	mutation(fit(g).get(i));
//	        }
	        for(String str : g) {
	        String a= str.toString().substring(1,4);
	        String a1=str.toString().substring(4,7);
	        int b=Integer.parseInt(a);
	        int b1=Integer.parseInt(a1);
	        Point origin=new Point(0,0);
	        Point p = null;
	        Random rn =new Random();
	        switch(b%9) {
	        case 0:
	        	p=origin;
	        	break;
	        case 1:
	        	 p=origin.move(origin).move(rn.nextInt(3), 0);
	        	 break;
	        case 2:
	        	 p=origin.move(origin).move(rn.nextInt(3), rn.nextInt(3));
	        	 break;
	        case 3:
	        	p=origin.move(origin).move(0, rn.nextInt(3));
	        	break;
	        case 4:
	        	p=origin.move(origin).move(rn.nextInt(3)-3, rn.nextInt(3));
	        	break;
	        case 5:
	        	p=origin.move(origin).move(rn.nextInt(3)-3, 0);
	        	break;
	        case 6:
	        	p=origin.move(rn.nextInt(3)-3, rn.nextInt(3)-3);
	        	break;
	        case 7:
	        	p=origin.move(origin).move(0, rn.nextInt(3)-3);
	        	break;
	        case 8:
	        	p=origin.move(origin).move(rn.nextInt(3), rn.nextInt(3)-3);
	        	break;
	        }
	        points.add(p);
	        
	        final Game.Behavior generations=Game.run(10, points,1000);
	        System.out.println(generations.growth);
	        for(int i=0;i<fit(g).size();i++) {
	        	mutation(fit(g).get(i));
	        }
	        long seed=System.currentTimeMillis();
	        System.out.println(seed);
	        RandomRegistry.setRandom(new Random(seed));
	        
	        	}
	       
	       
	     //   final Game.Behavior generations=Game.run(100, points);
	        }
	  //  final Game.Behavior generations=Game.run(100, points);
	        	
	        
//	        final Game.Behavior generations=Game.run(100, points);
//	        System.out.println(generations.toString());
	       
	       
	        //final Game.Behavior generations=Game.run(90, points);
	       // final Game.Behavior generations=GSystem.out.println(fit(g));ame.run(50, points);
	        
	        //System.out.println(Arrays.toString(g));
//	        System.out.println(g.getClass().toString());
	        //System.out.println(fit(g));
	      //start from here
//	        String[][] grid = generateGrid(50,50,points);
//	        
//	        int gen = 0;
//	        
//	        while(true) {
//	            clearScreen();
//	            printGrid(grid);
//	            System.out.println("Gen " + (gen++) + "");
//	            
//	            String[][] superGrid = copyGrid(grid);          
//	    
//	            for (int i = 0; i < grid.length; i++) {
//	                for (int j = 0; j < grid[i].length; j++) {
//	                    //System.out.println(grid[i][j] + " " + i + ":" + j);
//	    
//	                    int life_forms = 0;
//	    
//	                    ArrayList<String> neighbors = new ArrayList<String>();
//	       
//	       }}}
	        //end here
	    
	    public  static ArrayList<String> fit(String[]g) {
	    	int fitness = 0;
	    	int max=0;
	    	String kk=null;
	    	Random rand = new Random();
	    	//myNumber = rand.nextInt((100-0)+1)+0;
	    	int count = 0;
	    	ArrayList<String> b=new ArrayList<>();
	        for (String str : g) {
//	        	for(int i=0;i<str.length();i++) {
//	                 if(str.charAt(i)==1) {
//	                fitness++;
//	                
//	                }
//	                 }
	        	fitness = calcFitness(str);
	        	count ++;
	        	//System.out.println(str.charAt(1));
	        	if(fitness>max) {
	        		max=fitness;
	        		kk=str;
                	}
	        	if(count ==5){
	        		count = 0;
	        		max = 0;
	        		b.add(kk);
	        		kk = null;
	        	}
	        	}
	        
	        return b;
	        }
	    
	    //eval function
	    public static int calcFitness(String g) {

	       int fitness = 0;
	        for (int i = 0; i < 8; i++) {
	            if ( g.charAt(i)=='1') {
	                ++fitness;
	            }
	        }
	        
	        return fitness;
	    }
	    
	    
	    //customiz mutation
	    public  static void mutation(String kk) {
	    	Random rr=new Random();
	 
	    	switch(rr.nextInt(9)) {
	    	case 0:	
            	 kk=kk.replaceFirst("0", "1");
               break;
	    	case 1:
	    	   kk=kk.replaceAll("0", "1");
	    	  break;
	    	case 2:
	    		for(int i=0;i<2;i++) {
	    		kk=kk.replaceFirst("0", "1");}
               break;
	    	case 3:
	    		kk=rr.nextInt(2)+kk.substring(1,2)+rr.nextInt(2)+kk.substring(3,5)+rr.nextInt(2)+kk.substring(6,8);
	    	   break;
	    	case 4:
	    		kk=kk.replaceFirst("1", "0");
	    		break;
	    	case 5:
	    		String h=kk.substring(4, 8);
	    		kk=kk.substring(0,4)+h.replace("0", "1");
	    		break;
	    	case 6:
	    		  kk=kk.replaceFirst("1", "0");
	    		  break;
	    	case 7:
	    		for(int i=0;i<2;i++) {
		    		kk=kk.replaceFirst("1", "0");}
	    		break;
	    	case 8:
	    		break;
	    	   }
	
	    }

	    }
	    
	    
	  
		
	    
	  

		 
		


	
	
	
