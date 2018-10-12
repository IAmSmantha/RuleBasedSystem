package com.sample;

import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
        	Scanner scanner=new Scanner(System.in);
            
            while(true)
            {
            //设置分数           
            System.out.println("(退出请输入-1)\n请输入分数:");
            if(scanner.hasNext())
            {
            	Score score = new Score();
            	int sc=scanner.nextInt();
            	if(sc==-1)
            		break;
            	score.setScore(sc);
            	kSession.insert(score);
            	kSession.fireAllRules();
            }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Score {

        private int score;

        public int getScore() {
            return this.score;
        }

        public void setScore(int score) {
            this.score = score;
        }

    }

}
