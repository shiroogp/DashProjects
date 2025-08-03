/*
    LANShare - LAN file transfer.
    Copyright (C) 2016 Abdul Aris R. <abdularisrahmanudin10@gmail.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

#ifndef SETTINGSDIALOG_H
#define SETTINGSDIALOG_H

#include <QDialog>

//namespace Ui {
//class SettingsDialog;
//}

class SettingsDialog : public QObject
{
    Q_OBJECT

public:
    explicit SettingsDialog(QObject *parent = nullptr);
    ~SettingsDialog() override;

private Q_SLOTS:
    void onCancelClicked();
    void onSaveClicked();
    void onResetClicked();
    void onSelectDownDirClicked();

private:
    void assign();

//    SettingsDialog *ui;
};

#endif // SETTINGSDIALOG_H
