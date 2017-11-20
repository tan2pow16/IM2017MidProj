import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/*
 * Coded by tan2pow16 on GitHub, 2017. All rights reserved.
 * Our group name is "¤p¤ý¤l". (A proof that the code is indeed made by me)
 */

public class TestMidProjIM
{
	public static void generateTestFile(String file) throws IOException
	{
		Random rand = new Random();
		int nodes = rand.nextInt(476) + 25; // 25 to 500 nodes
		int[] costs = new int[nodes];
		int[] population = new int[nodes];
		int budget = 0;
		for(int i = 0 ; i < nodes ; i++)
		{
			costs[i] = rand.nextInt(901) + 100; // 100 to 1000 dollars per node
			population[i] = rand.nextInt(1376) + 125; // 125 to 1500 people per node.
			budget += costs[i];
		}
		budget /= 2; // budget = 0.5 * sum(costs)
		int t1 = 60;
		int t2 = 15 + rand.nextInt(26); // 1/4 to 2/3 coverage dist as satisfication dist.
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(nodes + " " + budget + " " + t1 + " " + t2 + "\r\n");
		for(int i = 0 ; i < nodes ; i++)
		{
			writer.write(population[i] + " ");
		}
		writer.write("\r\n");
		for(int i = 0 ; i < nodes ; i++)
		{
			writer.write(costs[i] + " ");
		}
		writer.write("\r\n");
		
		int mapConnectionSeed = rand.nextInt((t1 * nodes) / 2) + (t1 * nodes) / 2;
		for(int i = nodes ; i > 0 ; i--)
		{
			for(int j = 0 ; j < i ; j++)
			{
				int time = rand.nextInt(mapConnectionSeed);
				if(time >  2 * t1)
				{
					time = -1;
				}
				else if(time > t1)
				{
					time = time * t2 / (2 * t1);
				}
				writer.write(time + " ");
			}
			writer.write("\r\n");
		}
		writer.close();
	}
}