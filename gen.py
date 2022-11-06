# -*- coding: utf-8 -*-
import os
import shutil

# 设定文件路径
path = 'D:\\Development\\project\\python\\MyProject\\chageFileName\\templates\\'


def changeFileName(target: str, des: str):
    # 对目录下的文件进行遍历
    print("Start")
    print(os.listdir(path))
    for file in os.listdir(path):
        if os.path.isfile(os.path.join(path, file)) == True:
            new_name = file.replace(target, des)
            if (new_name == file):
                continue
            os.rename(os.path.join(path, file), os.path.join(path, new_name))
            print(new_name)
            print(new_name + "  --修改成功！")
    # 结束
    print("End")


movePath = 'D:\\Development\\project\\myself\\weichou-refactor\\backend\\src\\main\\java\\com\\duofan\\weichou\\'
# movePath = 'E:\\Project\\xyDemo\\PlaceManageSystem\\backend\\src\\main\\java\com\\wzh0\\placeMS\\'
conditionPath = movePath + 'controller\\v1\\condition\\business\\'
controllerPath = movePath + 'controller\\v1\\api\\'
requestPath = movePath + 'controller\\v1\\request\\business\\'
dtoPath = movePath + 'dto\\model\\business\\'
repositoryPath = movePath + 'repository\\business\\'
servicePath = movePath + 'service\\business\\'
mapperPath = movePath + 'dto\\mapper\\business\\'
modelPath = movePath + 'model\\business\\'

levelNameList = ["Condition", "Controller",
                 "Request", "Dto", "Repository", "Service", "Mapper"]


def getPath(name: str):
    if (name.find("Condition") != -1):
        return conditionPath
    if (name.find("Controller") != -1):
        return controllerPath
    if (name.find("Request") != -1):
        return requestPath
    if (name.find("Dto") != -1):
        return dtoPath
    if (name.find("Repository") != -1):
        return repositoryPath
    if (name.find("Service") != -1):
        return servicePath
    if (name.find("Mapper") != -1):
        return mapperPath
    if (name.find(".java") != -1):
        return modelPath
    return ''


def move():
    for file in os.listdir(path):
        desPath = getPath(file)
        if (desPath == ''):
            continue
        try:
            # shutil.move(path+file, desPath)
            shutil.copyfile(path + file, desPath + file)
            print(file + "--操作成功")
        except Exception as e:
            print(e)
            continue


print("输入要改成文件的名字：")
ModelName = input()
# 被改文件的名字
print("输入当前文件的名字：")
forModelName = input()

while (ModelName != ""):
    print("确认是：" + ModelName + " ？")
    print("确认是：" + forModelName + " ？")
    if (input() == "yes"):
        changeFileName(forModelName, ModelName)
        print("确认要移动：" + ModelName + "项目 ？")
        while (True):
            if (input() == "yes"):
                move()
                break
        break
    ModelName = input()
