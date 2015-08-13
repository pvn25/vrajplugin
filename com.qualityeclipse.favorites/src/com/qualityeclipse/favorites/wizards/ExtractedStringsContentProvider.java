package com.qualityeclipse.favorites.wizards;

import org.eclipse.jface.viewers.*;

/**
 * The content provider second page of the extract strings wizard
 */
public class ExtractedStringsContentProvider
      implements IStructuredContentProvider
{
   // dummy data
   private static final Object[] items =
         {
	   		   new ExtractedString("commit_comments", "id"), new ExtractedString("commit_comments", "commit_id"),
               new ExtractedString("commit_comments", "user_id"), new ExtractedString("commit_comments", "line"),
               new ExtractedString("commit_comments", "position"), new ExtractedString("commit_comments", "comment_id"),
               new ExtractedString("commits", "id"), new ExtractedString("commits", "author_id"),
               new ExtractedString("commits","committer_id"),new ExtractedString("commits","project_id"),
               new ExtractedString("followers","follower_id"),new ExtractedString("followers","user_id"),
               new ExtractedString("issue_comments","issue_id"),new ExtractedString("issue_comments","user_id"),
               new ExtractedString("issue_comments","comment_id"),new ExtractedString("issue_events","event_id"),
               new ExtractedString("issue_events","issue_id"),new ExtractedString("issue_events","actor_id"),
               new ExtractedString("issues","id"),new ExtractedString("issues","repo_id"),
               new ExtractedString("issues","reporter_id"),new ExtractedString("issues","assignee_id"),
               new ExtractedString("organization_members","org_id"),new ExtractedString("organization_members","user_id"),
               new ExtractedString("project_commits","project_id"),new ExtractedString("project_commits","commit_id"),
               new ExtractedString("project_members","repo_id"),new ExtractedString("project_members","user_id"),
               new ExtractedString("projects","id"),new ExtractedString("projects","owner_id"),
               new ExtractedString("projects","forked_from"),new ExtractedString("projects","deleted"),
               new ExtractedString("projects_with_forks","id"),new ExtractedString("pull_request_comments","pull_request_id"),
               new ExtractedString("pull_request_comments","user_id"),new ExtractedString("pull_request_comments","comment_id"),
               new ExtractedString("pull_request_comments","position"),new ExtractedString("pull_request_comments","body"),
               new ExtractedString("pull_request_comments","commit_id"),new ExtractedString("pull_request_commits","pull_request_id"),
               new ExtractedString("pull_request_commits","commit_id"),new ExtractedString("pull_request_history","id"),
               new ExtractedString("pull_request_history","pull_request_id"),new ExtractedString("pull_request_history","actor_id"),
               new ExtractedString("pull_requests","id"),new ExtractedString("pull_requests","head_repo_id"),
               new ExtractedString("pull_requests","base_repo_id"),new ExtractedString("pull_requests","head_commit_id"),
               new ExtractedString("pull_requests","base_commit_id"),new ExtractedString("pull_requests","pullreq_id"),
               new ExtractedString("pull_requests","intra_branch"),new ExtractedString("users","id"),
               new ExtractedString("watchers","repo_id"),new ExtractedString("watchers","user_id")    
         };

   public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
   }

   public Object[] getElements(Object inputElement) {
      return items;
   }

   public void dispose() {
   }
}