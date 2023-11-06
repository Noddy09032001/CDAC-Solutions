/*
core functionalities to be added:

1. Add a task. 
2. Check for duplicates
3. Sort the tasks based on first name, description, priority
4. Checking the task date should not be greater than the current task date
5. Mark the tasks as completed
6. Display all the tasks
7. Display the completed tasks
8. Display the pending tasks

*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class TaskManager{
    // data members included in the task
    private:
    string priority;
    string Taskstatus;
    string taskName, taskDescription;
    int taskID;

    public: 
    // default constructor for the Task Manager class
    TaskManager(){
        this->priority = "urgent";
        this->taskDescription = "sample task";
        this->taskName = "Current task";
        this->Taskstatus = "pending";
        this->taskID = 0;
    }

    void initialise(int taskid){
        this->taskID = taskid;   // initialising the task id

        cout<<"\nEnter the task name: ";
        getline(cin, this->taskName);

        cin.ignore();   // ignoring the next line so that there is no error in the input

        cout<<"\nEnter the task description: ";
        getline(cin, this->taskDescription);
        cin.ignore();

        cout<<"\nEnter the task priority: ";
        getline(cin, this->priority);
        cin.ignore();

        cout<<"\nEnter the cuurent status of the task: ";
        getline(cin, this->Taskstatus);
        
    }

    static bool checkForDuplicates(vector<TaskManager> tasks, int taskid){
        for(TaskManager getTasks : tasks){
            if(getTasks.taskID == taskid){
                return false;
            }
        }
        return true;
    }

    void displayTasks(){
        cout<<"\n====================================";
        cout<<"\nTask details: ";
        cout<<"\nTask ID: "<<this->taskID;
        cout<<"\nTask name: "<<this->taskName;
        cout<<"\nTask Description: "<<this->taskDescription;
        cout<<"\nTask Status: "<<this->Taskstatus;
        cout<<"\nTask Priority: "<<this->priority;
    }

    static void displayAllTasks(vector <TaskManager> tasksList);

    static void displayParticularTask(vector <TaskManager> tasksList, int id);

};


// defining some of the methods of the class outside the class using the scope 
// resolution operator of the class
void TaskManager ::displayAllTasks(vector <TaskManager> tasksList){
    for(TaskManager allTasks : tasksList)
        allTasks.displayTasks();
}

void TaskManager ::displayParticularTask(vector <TaskManager> tasksList, int id){
    for(TaskManager allTasks : tasksList){
        if(allTasks.taskID == id){
            allTasks.displayTasks();
        }
    }
}

int main(){
    cout<<"\n\nThe code for the task manager system: ";
    vector<TaskManager> tasks;  // creating a dynamic array of tasks
    int choice;
    bool running = true;

    while (running)
    {
        cout<<"\n 1.  Add a task   \n2. Show the details of all the tasks  \n3. Check for a following task";
        cout<<"\n Your choice: ";

        cin>>choice;
        switch(choice){

            case 1:{
                cout<<"\nEnter the task id: ";
                int taskID;
                cin>>taskID;
                bool answer = TaskManager ::checkForDuplicates(tasks, taskID);
                if(answer == false)
                    cout<<"\nThe given task already exists. The task cannot be added.";
                else{
                    TaskManager newTask;
                    newTask.initialise(taskID);
                    tasks.push_back(newTask);
                }
                break;
            }

            case 2:{
                cout<<"\nDiplaying all the tasks data: ";
                TaskManager::displayAllTasks(tasks);
                break;
            }

            case 3:{
                cout<<"\nFetching the details of a particular task: ";
                cout<<"\nEnter the task ID: ";
                int id;
                cin>>id;
                TaskManager::displayParticularTask(tasks,id);
                break;
            }

            case 4:{
                break;

            }

            default:{
                cout<<"\nExiting the task manager system.";
                running = false;
                break;
            }
        }
    }
    
}