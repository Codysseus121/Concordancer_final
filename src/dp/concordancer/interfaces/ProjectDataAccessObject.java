package dp.concordancer.interfaces;


import java.util.List;

import dp.model.concordancer.Project;
import dp.model.concordancer.ProjectInterface;
import dp.model.concordancer.UserInterface;

/*
 * Interface ProjectDataAccessObject defines methods for accessing projects in the database
 */

public interface ProjectDataAccessObject {
/*
 * Method getProjects for getting all projects of a single user.
 * @user: the user.
 * @return a List with the User's projects.
 */
 List<Project> getProjects(UserInterface user);
/*
 * Method deleteProject for deleting a single project from the database.
 * @user: the user.
 * @pid: the project's primary key.
 */

 boolean deleteProject(UserInterface u, int pid);

/*Method createProject to create a new Project.
 * @param user: the user.
 * @param projectname: the name of the project.
 * 
 */

 int createProject(UserInterface user, String projectname);
/*
 * Method getProject for getting a single project of a single user from the database.
 * @user: the user.
 * @return a Project object.
 */
 ProjectInterface getProject(int id, UserInterface u);

	
}
