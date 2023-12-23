#include <iostream>
#include <vector>
using namespace std;   // using the standard namespace

/*
1. Check for the duplicate addition of the cricketers
2. Add update remove and view the list of cricketers
3. View cricketers with a given average
4. View cricketers whose age is less than the given number
5. Sort the cricketers according to various parameters
6. If possible use file handling to store the final sorted data of the cricketers

*/

class Cricketers{

    // defining the data fields for the members 
    private:

    string name;
    string teamName;
    float battingAvg;
    int playerID;
    float bowlingAvg;

    bool playsForTeam;

    // defining the member functions
    public:

    // function to get the player data for the same
    void getPlayerData(int playerID, string playerName){
        cout<<"==========================================\n";
        cout<<"Enter the player details: ";

        cout<<"Team Name: ";
        cin>>this->teamName;

        cout<<"Batting Average: ";
        cin>>this->battingAvg;

        cout<<"Bowling Average: ";
        cin>>this->bowlingAvg;

        this->name = playerName;
        this->playerID = playerID;  // setting the auto generated player id
        this->playsForTeam = true;   // setting the playing status of the player to be true, which means he already plays for the team

        cout<<"==========================================";

    }

    static bool checkDuplicates(string playerName, vector<Cricketers>playersData){
        for(Cricketers players : playersData){
            if(players.name.compare(playerName) == 0 && players.playsForTeam == true){
                return true;   // this means duplicates exist
            }
        }
        return false;  // this means no duplicates exist
    }

    static string updatePlayerData(int playerID,vector<Cricketers> playersData);

    void getDetailsByTeam(string teamName, vector<Cricketers> playersData);

    void display(){
        cout<<"\n=============================================\n";
        cout<<"Player  "<<this->playerID<<": ";
        cout<<"Name: "<<this->name;
        cout<<"Team: "<<this->teamName;
        cout<<"Batting average: "<<this->battingAvg;
        cout<<"Bowling average: "<<this->bowlingAvg;
         cout<<"\n=============================================\n";
    }
};

// function to update the details of the player according to the player id

string Cricketers::updatePlayerData(int playerID, vector<Cricketers> playersData){

    Cricketers newPlayer;
    for(Cricketers players : playersData){
        if(players.playerID == playerID){
            newPlayer = players;     // storing the found player into a new player object
        }
    }

    bool running = true;
    int choice;
    while (running)
    {
        cout<<"\n1. Batting Average  \n2. Bowling Average \nEnter the field to be updated: ";
        cin>>choice;
        switch (choice)
        {
            case 1:
            {
                float battingAvg;
                cout<<"\nEnter the new batting average: ";
                cin>>battingAvg;
                newPlayer.battingAvg = battingAvg;
                cout<<"\nThe batting average has been updated successfully";
                break;
            }

            case 2:{

                float bowlingAvg;
                cout<<"Enter the new bowling average: ";
                cin>>bowlingAvg;
                newPlayer.bowlingAvg = bowlingAvg;
                cout<<"\nThe bowling average has been updated successfully";
                break;
            }

            default:
            {
                running = false;
                break;
            }
        }
    }

    return "The player details have been added successfully";
}

// function to get the details of the team according to the team name. The details include the average batting and bowling statistics of the team

void Cricketers::getDetailsByTeam(string teamName, vector<Cricketers> playersData){

}


int main(){

    cout<<"\n==========================================\n";
    cout<<"Team Management System: ";
    vector<Cricketers> playersData;   // defining the vector of players 
    int choice;
    int playerId = 0;
    bool running = true;

    while (running)
    {
        cout<<"\n1. Add a player to the team  \n2. Update particular player data  \n3. Display all players  \n4. Get the average statistics of the players per team ";
        cout<<"\nYour choice: ";
        cin>>choice;
        switch (choice)
        {
            case 1:
            {
                string playerName;
                cout<<"\nName of the player: ";
                cin>>playerName;
                bool answer = Cricketers::checkDuplicates(playerName, playersData);  // passing the players name and the vector of players for the duplicates checking
                if(answer == true)
                    cout<<"\nThe player already plays for the team. So he cannot be added. Re enter the data again";
                else{
                    Cricketers newPlayer;
                    newPlayer.getPlayerData(playerId++, playerName);
                    playersData.push_back(newPlayer);     // adding the new player to the list of players for the team
                    cout<<"\nThe player has been added successfully to the team";
                }
                break;
            }

            case 2:
            {
                int id;
                cout<<"Enter the ID of the player whose details need to be updated: ";
                cin>>id;
                string answer = Cricketers ::updatePlayerData(id, playersData);
                cout<<answer;
                break;
            }

            case 3:{
                
                cout<<"\n=====================================================\n";
                cout<<"Player details: ";
                for(Cricketers players : playersData){
                    players.display();  // displaying the details of the players in the list
                }
                break;
            }

            case 4:{
                break;
            }
        
            default:{
                running = false;
                break;
            }

        } // switch case ends here

    }  // the while loop ends here

} // end of the main class