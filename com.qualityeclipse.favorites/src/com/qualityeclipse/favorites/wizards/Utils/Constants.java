package com.qualityeclipse.favorites.wizards.Utils;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
//import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import com.qualityeclipse.favorites.wizards.ExtractStringsWizard;
import java.util.Vector;

public final class Constants { 
	//GH Dataset:
	
    public static final String DATASET_DIRECTORY_GH_MySQL = "D:\\ghtorrent\\SQL";
    public static final String DATASET_EXTERNAL_DIRECTORY_GH_MySQL = "E:\\Influentials\\DataSet\\MySQL-20150401\\SQL";
    public static final String DATASET_DIRECTORY_GH_TSV = "D:\\ghtorrent\\TSV";
    public static final String DATASET_EXTERNAL_DIRECTORY_GH_TSV = "E:\\Influentials\\DataSet\\MySQL-20150401\\TSV";
    static ExtractStringsWizard sswp = new ExtractStringsWizard();
    
    public static HashMap <String,List<String>> DUMP_TABLES_AND_THEIR_FIELDS = new HashMap<String,List<String>>(){{
    	put("commit_comments:neededFields", Arrays.asList(new String[] { "id", "commit_id", "user_id", "line", "position", "comment_id"}));
    	put("commit_comments:titlesForNeededFields", Arrays.asList(new String[] { "id", "commit_id", "user_id", "line", "position", "comment_id"}));
    	put("commit_comments:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { "body"}));
    	 put("commits:neededFields", Arrays.asList(new String[] { "id", "author_id", "committer_id", "project_id" }));
	        put("commits:titlesForNeededFields", Arrays.asList(new String[] { "id", "authorId", "committerId", "projectId" }));
	        put("commits:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("followers:neededFields", Arrays.asList(new String[] { "follower_id", "user_id" }));
	        put("followers:titlesForNeededFields", Arrays.asList(new String[] { "followerId", "userId" }));
	        put("followers:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { })) ;
	        put("issue_comments:neededFields", Arrays.asList(new String[] { "issue_id", "user_id", "comment_id" }));
	        put("issue_comments:titlesForNeededFields", Arrays.asList(new String[] { "issueId", "userId", "commentId" }));
	        put("issue_comments:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("issue_events:neededFields", Arrays.asList(new String[] { "event_id", "issue_id", "actor_id" }));
	        put("issue_events:titlesForNeededFields", Arrays.asList(new String[] { "eventId", "issueId", "actorId" }));
	        put("issue_events:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("issues:neededFields", Arrays.asList(new String[] { "id", "repo_id", "reporter_id", "assignee_id" }));
	        put("issues:titlesForNeededFields", Arrays.asList(new String[] { "id", "repoId", "reporterId", "assigneeId" }));
	        put("issues:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("organization_members:neededFields", Arrays.asList(new String[] { "org_id", "user_id" }));
	        put("organization_members:titlesForNeededFields", Arrays.asList(new String[] { "orgId", "userId" }));
	        put("organization_members:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("project_commits:neededFields", Arrays.asList(new String[] { "project_id", "commit_id" }));
	        put("project_commits:titlesForNeededFields", Arrays.asList(new String[] { "projectId", "commitId" }));
	        put("project_commits:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("project_members:neededFields", Arrays.asList(new String[] { "repo_id", "user_id" }));
	        put("project_members:titlesForNeededFields", Arrays.asList(new String[] { "repoId", "userId" }));
	        put("project_members:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("projects:neededFields", Arrays.asList(new String[] { "id", "owner_id", "forked_from", "deleted" }));
	        put("projects:titlesForNeededFields", Arrays.asList(new String[] { "id", "ownerId", "forkedFrom", "deleted" }));
	        put("projects:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("projects_with_forks:neededFields", Arrays.asList(new String[] { "id" }));
	        put("projects_with_forks:titlesForNeededFields", Arrays.asList(new String[] { "id" }));
	        put("projects_with_forks:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("pull_request_comments:neededFields", Arrays.asList(new String[] { "pull_request_id", "user_id", "comment_id", "position", "body", "commit_id" }));
	        put("pull_request_comments:titlesForNeededFields", Arrays.asList(new String[] { "pullRequestId", "userId", "commentId", "position", "body", "commitId" }));
	        put("pull_request_comments:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { "body" }));
	        put("pull_request_commits:neededFields", Arrays.asList(new String[] { "pull_request_id", "commit_id" }));
	        put("pull_request_commits:titlesForNeededFields", Arrays.asList(new String[] { "pullRequestId", "commitId" }));
	        put("pull_request_commits:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("pull_request_history:neededFields", Arrays.asList(new String[] { "id", "pull_request_id", "actor_id" }));
	        put("pull_request_history:titlesForNeededFields", Arrays.asList(new String[] { "id", "pullRequestId", "actorId" }));
	        put("pull_request_history:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("pull_requests:neededFields", Arrays.asList(new String[] { "id", "head_repo_id", "base_repo_id", "head_commit_id", "base_commit_id", "pullreq_id", "intra_branch" }));
	        put("pull_requests:titlesForNeededFields", Arrays.asList(new String[] { "id", "headRepoId", "baseRepoId", "headCommitId", "baseCommitId", "pullreqId", "intraBranch" }));
	        put("pull_requests:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
	        put("users:neededFields", Arrays.asList(new String[] { "id" }));
	        put("users:titlesForNeededFields", Arrays.asList(new String[] { "id" }));
	        put("users:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] {  }));
	        put("watchers:neededFields", Arrays.asList(new String[] { "repo_id", "user_id" }));
	        put("watchers:titlesForNeededFields", Arrays.asList(new String[] { "repoId", "userId" }));
	        put("watchers:fieldsToRemoveInvalidCharacters", Arrays.asList(new String[] { }));
    
    }};
  public static final HashMap <String,Vector> DUMP_TABLES_AND_THEIR_FIELDS1 = new HashMap<String,Vector>();
  
    public static final String allValidCharactersInGH_Descriptions_ForRegEx = "a-zA-Z0-9\\.\\#\\+\\-\\_\\@\\(\\)\\[\\]\\{\\}\\*\\!\\,\\:\\;";  
	public static final String SEPARATOR_FOR_TABLE_AND_FIELD = ":";
	public static final String SEPARATOR_FOR_FIELDS_IN_TSV_FILE = "\t";
	public static final DecimalFormat integerFormatter = new DecimalFormat("###,###");
	public static final DecimalFormat floatFormatter = new DecimalFormat("###,###.#");
	public static final DecimalFormat highPrecisionFloatFormatter = new DecimalFormat("###,###.######");
	public static final int NUMBER_OF_TAB_CHARACTERS = 4;

	public static final String ALL = "ALL";
	
	public static final long THIS_IS_A_TEST = 10000;
	public static final long THIS_IS_REAL = -1;//unlimited!
	public static final int AN_EXTREMELY_NEGATIVE_INT = -999999; 
	//Sort order:
	public enum SortOrder{ 
		ASCENDING_INTEGER, DESCENDING_INTEGER, DEFAULT_FOR_STRING
	}

	public enum FieldType{
		INTEGER, STRING, NOT_IMPORTANT
	}

	public enum LogicalOperand { 
		NO_CONDITION, AND, OR, IGNORE_THE_SECOND_OPERAND
	}

	public enum ConditionType {
		EQUALS, NOT_EQUALS, NOTHING, GREATER_OR_EQUAL
	}
	public void func(){
		if(sswp.flag[0]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("commit_comments:neededFields",sswp.st0);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("commit_comments:titlesForNeededFields",sswp.st0);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("commit_comments:fieldsToRemoveInvalidCharacters",sswp.v);
		sswp.flag[0] = false;
		}
		if(sswp.flag[1]){
			DUMP_TABLES_AND_THEIR_FIELDS1.put("commits:neededFields", sswp.st1);
			DUMP_TABLES_AND_THEIR_FIELDS1.put("commits:titlesForNeededFields",sswp.st1);
			DUMP_TABLES_AND_THEIR_FIELDS1.put("commits:fieldsToRemoveInvalidCharacters",sswp.v);sswp.flag[1] = false;
		}
		if(sswp.flag[2]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("followers:neededFields", sswp.st2);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("followers:titlesForNeededFields",sswp.st2 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("followers:fieldsToRemoveInvalidCharacters",sswp.v) ;sswp.flag[2] = false;
		}
		if(sswp.flag[3]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("issue_comments:neededFields", sswp.st3);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("issue_comments:titlesForNeededFields",sswp.st3);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("issue_comments:fieldsToRemoveInvalidCharacters",sswp.v);sswp.flag[3] = false;
		}
		if(sswp.flag[4]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("issue_events:neededFields",sswp.st4);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("issue_events:titlesForNeededFields",sswp.st4 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("issue_events:fieldsToRemoveInvalidCharacters",sswp.v);sswp.flag[4] = false;
		}
		if(sswp.flag[5]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("issues:neededFields",sswp.st5);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("issues:titlesForNeededFields",sswp.st5 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("issues:fieldsToRemoveInvalidCharacters",sswp.v);sswp.flag[5] = false;
		}
		if(sswp.flag[6]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("organization_members:neededFields", sswp.st6);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("organization_members:titlesForNeededFields",sswp.st6 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("organization_members:fieldsToRemoveInvalidCharacters",sswp.v );sswp.flag[6] = false;
		}
		if(sswp.flag[7]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("project_commits:neededFields", sswp.st7);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("project_commits:titlesForNeededFields",sswp.st7 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("project_commits:fieldsToRemoveInvalidCharacters",sswp.v );sswp.flag[7] = false;
		}
		if(sswp.flag[8]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("project_members:neededFields", sswp.st8);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("project_members:titlesForNeededFields",sswp.st8 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("project_members:fieldsToRemoveInvalidCharacters",sswp.v );sswp.flag[8] = false;
		}
		if(sswp.flag[9]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("projects:neededFields",sswp.st9);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("projects:titlesForNeededFields",sswp.st9 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("projects:fieldsToRemoveInvalidCharacters",sswp.v);sswp.flag[9] = false;
		}
		if(sswp.flag[10]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("projects_with_forks:neededFields", sswp.st10);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("projects_with_forks:titlesForNeededFields",sswp.st10 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("projects_with_forks:fieldsToRemoveInvalidCharacters",sswp.v );sswp.flag[10] = false;
		}
		if(sswp.flag[11]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_request_comments:neededFields", sswp.st11);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_request_comments:titlesForNeededFields",sswp.st11 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_request_comments:fieldsToRemoveInvalidCharacters",sswp.v );sswp.flag[11] = false;
		}
		if(sswp.flag[12]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_request_commits:neededFields", sswp.st12);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_request_commits:titlesForNeededFields",sswp.st12 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_request_commits:fieldsToRemoveInvalidCharacters",sswp.v);sswp.flag[12] = false;
		}
		if(sswp.flag[13]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_request_history:neededFields", sswp.st13);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_request_history:titlesForNeededFields",sswp.st13);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_request_history:fieldsToRemoveInvalidCharacters",sswp.v );sswp.flag[13] = false;
		}
		if(sswp.flag[14]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_requests:neededFields", sswp.st14);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_requests:titlesForNeededFields",sswp.st14);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("pull_requests:fieldsToRemoveInvalidCharacters",sswp.v );sswp.flag[14] = false;
		}
		if(sswp.flag[15]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("users:neededFields", sswp.st15);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("users:titlesForNeededFields",sswp.st15 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("users:fieldsToRemoveInvalidCharacters",sswp.v );sswp.flag[15] = false;
		}
		if(sswp.flag[16]){
		DUMP_TABLES_AND_THEIR_FIELDS1.put("watchers:neededFields", sswp.st16);
		DUMP_TABLES_AND_THEIR_FIELDS1.put("watchers:titlesForNeededFields",sswp.st16 );
		DUMP_TABLES_AND_THEIR_FIELDS1.put("watchers:fieldsToRemoveInvalidCharacters",sswp.v );sswp.flag[16] = false;
		}

	}
	/*
	public static void main(String[] args) {
		System.out.println("dfewf"+sswp.strarrlist);
		String s = "abcdeababcdecdejhgabcde";
		System.out.println(s);
		s = s.replaceAll("abcde", "");
		s = s.replaceAll("abcde", "");
		System.out.println(s);
//		s = s.replaceAll("\\\\'", "  ");
//		System.out.println(s);
////		System.out.println("asfadf".substring(0, "asfadf".indexOf(",")));
//		System.out.println("---------------- Constants.java: ----------------");
//		String s1 = "2013-05-25T21:50:02Z";
//		String s2 = "2011-07-25T21:50:02Z";
//		if (s1.compareTo(s2) > 0) //if s1 > s2 ==> returns positive value.
//			System.out.println("1111");
//		else
//			System.out.println("2222");
		
		Date d1 = new Date();
		s= "";
		for (int i=0; i<7000; i++)
			s = s + "a";
		Date d2 = new Date();
		System.out.println((d2.getTime()-d1.getTime())/1000);

		double a = 0.0000004;
		System.out.println(highPrecisionFloatFormatter.format(0.0000004));
		System.out.println(Constants.highPrecisionFloatFormatter.format(a));
	}
*/
}
//Iterating:
//	for (Map.Entry<String, List<String>> entry : Constants.USEFUL_FIELDS_IN_JSON_FILES.entrySet())
//		System.out.println(entry.getKey() + "    ------>    " + entry.getValue());

