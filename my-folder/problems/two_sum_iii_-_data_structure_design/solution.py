class TwoSum:
    
    def __init__(self):
        self.dict = {}

    def add(self, number: int) -> None:
        if number in self.dict:
            self.dict[number] += 1
        else:
            self.dict[number] = 1

    def find(self, value: int) -> bool:
        for item in self.dict.keys():
            complement = value- item
            if item != complement:                
                if complement in self.dict:
                    return True
            elif self.dict[item] >1:
                return True
        return False        


# Your TwoSum object will be instantiated and called as such:
# obj = TwoSum()
# obj.add(number)
# param_2 = obj.find(value)