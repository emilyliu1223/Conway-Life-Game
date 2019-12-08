package edu.neu.coe.info6205.life.base;

import org.junit.Test;

import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Chromosome;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.util.Factory;

import static edu.neu.coe.info6205.life.base.Life.*;

import java.util.Arrays;


public class LifeTest {
	
	@Test
	public void testCalFitness() {
		
		Genotype<BitGene> genotype = Genotype . of (
				
				BitChromosome. of (10, 0.4) , 
				BitChromosome . of (20, 0.8) ,
				BitChromosome . of (30, 0.9) ,
				BitChromosome. of (40, 0.5)
		);
		
		
		Life life = new Life();
	
		for(Chromosome<BitGene> bc : genotype) {
//			System.out.println(bc);
			String str = bc.toString();
		
			System.out.println(life.calcFitness(str));
		}
		
	}
	
	
	
	@Test
	public void testMutation() {
			
		Genotype<BitGene> genotype2 = Genotype . of (
				
				BitChromosome. of (10, 0.4) , 
				BitChromosome . of (20, 0.8) ,
				BitChromosome . of (30, 0.9) ,
				BitChromosome. of (40, 0.5)
		);
		
		Life life = new Life();
		
		for(Chromosome<BitGene> bc : genotype2) {
			System.out.println(bc); 
			String b=bc.toString();
			System.out.println(Life.mutation(b));

		     	}
			
		}
	@Test
public void testFit() {
		
		Genotype<BitGene> genotype3 = Genotype . of (
				
				BitChromosome. of (10, 0.4) , 
				BitChromosome . of (20, 0.8) ,
				BitChromosome . of (30, 0.9) ,
				BitChromosome. of (40, 0.5)
		);
		
		
		Life life = new Life();
	
		for(Chromosome<BitGene> bc : genotype3) {
			System.out.println(bc);
			 String[] g=bc.toString().split("\\|");
		
			System.out.println(life.fit(g));
		}
		
	}
		
	
}
