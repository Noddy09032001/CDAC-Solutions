#include <iostream>
#include <vector>

using namespace std;

// defining the materials enum for the use of the class in objects later
enum Material{

    Plastic = 1,
    Alloy_Steel = 2,
    Metal = 3,
    Carbon = 4
};

const string materialToString(Material material){
    switch (material)
    {
        case Plastic:{
            return "Plastic";
        }
        case Alloy_Steel: return "Alloy_Steel";
        case Metal: return "Metal";
        case Carbon: return "Carbon";
        default: return "Unknown Material";
    }
}

class Pen{

    private:

    int penID;
    string BrandName;
    string color;
    float price;
    string penMaterial;  // creating an object of the enum for getting the material of the pen
    int penStock;

    public:

    /*
    here check duplicates will work in another way, if the name and the brand name of the pen is same then it will redirect to the add stock function of the class
    if we dont want to add the stock then we can exit. Hence the duplicate will not get added in the list
    */

    static bool checkDuplicates(string penBrand, vector<Pen> pensData){
        int choice;
        int addStock;
        for(Pen pen : pensData){
            if(pen.BrandName.compare(penBrand) == 0){  // this means the names match, compare function returns 0 when same
                cout<<"Add stock: 1. Yes 2. No: Your choice: ";
                cin>>choice;

                if(choice == 1){
                    cout<<"Enter the number of pens to be added: ";
                    cin>>addStock;

                    if(pen.penStock == 0){
                        pen.penStock = addStock;
                    }
                    else{
                        pen.penStock+=addStock;
                    }
                }
            }
            return true;   // duplicates found stock has been changed
        }

        return false;  // no duplicates found
    }

    void getPenData(int penID, string brand){
        
        cout<<"Enter the details of the pen: ";

        cout<<"Color: ";
        cin>>this->color;

        cout<<"Price: ";
        cin>>this->price;

        cout<<"Material: ";
        for ( int i = Plastic; i <= Carbon; i++)
        {
            Material currentMaterial = static_cast<Material> (i);
            cout<<"Value: "<<i<<"Name: "<< materialToString(currentMaterial);
        }
        cout<<"Your choice: ";
        int choice;
        cin>>choice;

        this->penMaterial = materialToString(static_cast<Material>(choice));
        

        cout<<"Stock: ";
        cin>>this->penStock;

        this->penID = penID;
        this->BrandName = brand;
    }

    static string updatePenData(int penId, vector<Pen> penData){
        Pen currentPen;
        for(Pen pens : penData){
            if(pens.penID == penId){
                currentPen = pens;   // storing the found pens object in a new variable
            }
        }

        bool running = true;
        int choice;
        while (running)
        {
            cout<<"\n1. Add the stock of the existing pen brand:  \n2. Change the color of the brand:  \n3. Change the price: \nYour choice: ";
            cin>>choice;
            switch(choice){

                case 1:{
                    int addstock;
                    cout<<"\nEnter the quantity to be added: ";
                    cin>>addstock;

                    currentPen.penStock+=addstock;
                    cout<<"\nStock updation successfull";
                    break;
                }

                case 2:{
                    
                    string newColor;
                    cout<<"\nEnter the color to be changed: ";
                    cin>>newColor;
                    currentPen.color = newColor;
                    cout<<"\nThe color of the pen has been changed successfully";
                    break;
                }

                case 3:{
                    float updatedPrice;   // the variable by which the price of the pens will be changed
                    cout<<"Enter the changed price: ";
                    cin>>updatedPrice;
                    currentPen.price = updatedPrice;  // setting the updated price for the current price
                    cout<<"\nThe price has been changed for the pen successfully";
                    break;
                }

                default:{
                    running = false;
                    break;
                }
            }
        }        
    }

    string giveDiscountForSpecificID(int penID, vector<Pen> penData);
    void display();

};

string Pen :: giveDiscountForSpecificID(int penID, vector<Pen> penData){
    // the new peice will be the original price - the price * percent discount
    int percentDiscount;
    for(Pen currentPen : penData){
        if(currentPen.penID == penID){   // checking if the penID of the pens match with the corresponding user entered ID
            cout<<"\nEnter the percent discount to be given: ";
            cin>>percentDiscount;

            currentPen.price = currentPen.price - ((percentDiscount/100)*currentPen.price);
            return "\nThe price of the pen has been updated";
        }
    }
    return "The pen with the given pen id does not exist in the stock. Discount could not be applied for the same";
}

void Pen :: display(){

}



int main(){

    cout<<"\n==========================================\n";
    cout<<"Pens Management System: ";
    vector<Pen> PenData;   // defining the vector of players 
    int choice;
    int penID = 0;
    bool running = true;

    while (running)
    {
        cout<<"\n1. Add a pen:  \n2. Update particular pen data:  \n3. Display all pens:  \n4. Give discount to a particular pen brand: ";
        cout<<"\nYour choice: ";
        cin>>choice;
        switch (choice)
        {
            case 1:
            {
                string penBrandName;
                cout<<"\nBrand: ";
                cin>>penBrandName;
                bool answer = Pen::checkDuplicates(penBrandName, PenData);  // passing the players name and the vector of players for the duplicates checking
                if(answer == true)
                    cout<<"\nThe pen name and brand already exists. Update the stock of the pen?";
                else{
                    Pen newPen;
                    newPen.getPenData(penID++, penBrandName);
                    PenData.push_back(newPen);     // adding the new player to the list of players for the team
                    cout<<"\nThe pen has been successfully added to the itenary";
                }
                break;
            }

            case 2:
            {
                int id;
                cout<<"Enter the ID of the pen whose details need to be updated: ";
                cin>>id;
                string answer = Pen ::updatePenData(id, PenData);
                cout<<answer;
                break;
            }

            case 3:{
                
                cout<<"\n=====================================================\n";
                cout<<"Pen stock details: ";
                for(Pen  pens : PenData){
                    pens.display();  // displaying the details of the players in the list
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

/*

insertOne({ "Name" : "Coffee", "Price" : 100, "Quantity" : 5 })



*/