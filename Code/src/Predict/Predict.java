package Predict;

import MainPackage.Main;
import ProjectManagement.Project;
import ResourceManagement.Resource;
import UI.Predict.Domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import DB.DBManager;

public class Predict {

	private List<List<Resource>> predictHistoryList;
	List<Project> result;

	public List<Project> requirementPredict(ArrayList<String> resources) {
		result = new ArrayList<>();
		List<Project> allProjects = Main.dbManager.getProjects();
		if (allProjects != null) {
			for (int i = 0; i < allProjects.size(); i++) {
				if (allProjects.get(i).hasResources(resources) && !result.contains(allProjects.get(i))) {
					result.add(allProjects.get(i));
				}
			}
		}

		if (resources.size() == 0)
			return allProjects;
		return result;
	}

	public List<Project> resourcePredict(ArrayList<String> technologies, Domain humanResources, Domain users,
			Domain modules) {
		result = new ArrayList<>();
		List<Project> allProjects = Main.dbManager.getProjects();

		if (allProjects != null) {
			for (int i = 0; i < allProjects.size(); i++) {
				if (technologies.size() != 0) {
						if (allProjects.get(i).hasResources(technologies) &&
								allProjects.get(i).matchSize(humanResources, users, modules)) {
								if (!result.contains(allProjects.get(i))) {
										result.add(allProjects.get(i));
									}
								
					}
				} else if (technologies.size() == 0) {
					if (allProjects.get(i).matchSize(humanResources, users, modules)) {
						if (!result.contains(allProjects.get(i))) {
							result.add(allProjects.get(i));

						}
					}
				}
			}
		}
		return result;

	}

}
